$(document).ready(function() {
  result = new Array();
	$('#submit').click(function(event) {
		var deptName = $('#SbDept').val();
		//alert(deptName);
		$.getJSON('EmpSelectServlet',{deptName:deptName},function(json) {
			$('#emptable').empty();//空にする

      //employees = JSON.stringify(json);
      employees = json;

      //table header
	  	$('#emptable').append(
          "<tr><th></th>" +
          "<th>社員ID</th>" +
          "<th>名前</th>" +
          "<th>部署</th>" +
          "<th>役職</th>" +
          "<th>職層コード</th></tr>");
      //table row
			for(var i in json){
				$('#emptable').append(
          "<tr><td>" +
          "<input type='checkbox' name='emp' value='" +json[i].empId+ "'>"+
          "</td>" +
          "<td>" + json[i].empId + "</td>" +
          "<td>" + json[i].name + "</td>" +
          "<td>" + json[i].dept.name + "</td>" +
          "<td>" + json[i].yakusyoku + "</td>" +
          "<td>" + json[i].layerCode + "</td></tr>");
			}
		});
	});

	$('#add').click(function(event) {
    check = employees.filter(function(item, index){
        if (checkbox_filter(item.empId)) return true;
    });

    for(var i in check){
      if(result_hold(check[i].empId)) {
        result.push(check[i]);
      }else{
        alert(check[i].empId + "は既に追加されているので追加できません");
      }
    }

    update_resulttable();
	});

  function update_resulttable() {
    $('#resulttable').empty();//空にする
    $('#resulttable').append(
        "<tr><th></th>" +
        "<th>社員ID</th>" +
        "<th>名前</th>" +
        "<th>部署</th>" +
        "<th>役職</th>" +
        "<th>職層コード</th></tr>");
    //table row
    for(var i in result){
      $('#resulttable').append(
        "<tr><td>" +
       // "<input type='checkbox' name='emp' value='" +result[i].empId+ "'>"+
        "<input type='button' id='" + result[i].empId +"' value='削除' class='delete'/>" +
        "</td>" +
        "<td>" + result[i].empId + "</td>" +
        "<td>" + result[i].name + "</td>" +
        "<td>" + result[i].dept.name + "</td>" +
        "<td>" + result[i].yakusyoku + "</td>" +
        "<td>" + result[i].layerCode + "</td></tr>");
    }
  };

  //削除ボタン押下イベント
  $(document).on("click", ".delete", function(){
    //alert("delete click! = " + $(this).attr("id") );
    for(var i in result){
      if(result[i].empId == $(this).attr("id")){
        result.splice(i,1);
      };
    };
    update_resulttable();
  });

  //checkboxにチェックが入っているidでemployeesをフィルタリング
  function checkbox_filter(empId) {
    var hoge = false;
    $("[name='emp']:checked").each(function(){
      if (empId == $(this).val()) hoge = true;
    });
    return hoge;
  };

  //resultに入っているか確認
  function result_hold(empId) {
    var hoge = true;
    for(var i in result){
      if (result[i].empId == empId ) hoge = false;
    };
    return hoge;
  };
});

