package jp.ash.taglib;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * メッセージ表示タグライブラリ
**/
public class EmpTag extends BodyTagSupport {
	private File out=null;

    /* defaultの
	doStartTag() 	EVAL_BODY_BUFFEREDを返す。ボディ部の評価結果は、bodyContentに格納される。
	doInitBody() 	何もしない
	doAfterBody() 	SKIP_BODYを返す。bodyContentに対して何もしない。
	doEndTag()  	EVAL_PAGEを返す。
	*/

	public void setFile(String path){
		out=new File(path);
	}
	 public int doAfterBody() throws JspException{
		 try{
			 BodyContent bodycontent = getBodyContent();
			 String body = bodycontent.getString();
			 JspWriter out = bodycontent.getEnclosingWriter();
			 StringBuffer buffer = new StringBuffer();

			 System.out.print("@@@@@@@@@@@@@@@");
			 System.out.print(body);
			 System.out.print("###############");

			 //body部のxmlをDocumentオブジェクトに変換
			 DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder docbuilder = dbfactory.newDocumentBuilder();
			 org.w3c.dom.Document doc = docbuilder.parse(new ByteArrayInputStream(body.getBytes("UTF-8")));

			 NodeList children = doc.getChildNodes();
			 //xmlout(children, 1);
			 valueOut(children, out);

			 out.print(doc.getElementsByTagName("userFilter"));
		 }catch(IOException e){
			 throw new JspException(e.getMessage());
		 } catch (ParserConfigurationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		 return(SKIP_BODY);
	 }

	 private String getElementContent(Element e, String TagName) {
		 NodeList nl = e.getElementsByTagName(TagName);
		 Node n = nl.item(0);
		 Node content = n.getFirstChild();
		 return content.getNodeValue();
	 }

	 private void valueOut(NodeList nodeList, JspWriter out) {
		 for (int i = 0; i < nodeList.getLength(); i++) {
			 Node child = nodeList.item(i);
			 if (child.getNodeName() == "userFilter") {
				 NodeList userFilterChildren = child.getChildNodes();//userFilterの子供を取得
				 for(int j = 0 ; j < userFilterChildren.getLength(); j++) {
					 if(userFilterChildren.item(j).getNodeName() == "layerCode") {//LsyerCodeがあれば
						 System.out.println("***** layerCode = " + getElementContent((Element)child, "layerCode"));
					 }
					 if(userFilterChildren.item(j).getNodeName() == "pstnCode") {//pstnCodeがあれば
						 System.out.println("***** pstnCode = " + getElementContent((Element)child, "pstnCode"));
					 }
				 }
			 }
			 valueOut(child.getChildNodes(), out);
		 }
	}

	 private void xmlout(NodeList nodeList, int kaisou) {
		 for (int i = 0; i < nodeList.getLength(); i++) {
			 Node child = nodeList.item(i);
			 //if( child.getNodeName() == "#text" ) continue;
			 System.out.println("### children $" + kaisou + "--> name: " +  child.getNodeName() + ", value: " + child.getNodeValue().trim() + " ###");
			 if(child.hasChildNodes()) {
				 xmlout(child.getChildNodes(), kaisou++);
			 }
		 }
	}
}
