$(function() {
	setModal();
})
 
function setModal() {

	//HTML�ǂݍ��ݎ��Ƀ��[�_���E�B���h�E�̈ʒu���Z���^�[�ɒ���
	adjustCenter("div#modal div.container");
 
	//�E�B���h�E���T�C�Y���Ƀ��[�_���E�B���h�E�̈ʒu���Z���^�[�ɒ���
	$(window).resize(function() {
		adjustCenter("div#modal div.container");
	});
 
	//�w�i���N���b�N���ꂽ���Ƀ��[�_���E�B���h�E�����
	$("div#modal div.background").click(function() {
		displayModal(false);
	});
 
	//�����N���N���b�N���ꂽ����Ajax�ŃR���e���c��ǂݍ���
	$("a.modal").click(function() {
		$("div#modal div.container").load($(this).attr("href"), data="html", onComplete);
		return false;
	});
 
	//�R���e���c�̓ǂݍ��݊������Ƀ��[�_���E�B���h�E���J��
	function onComplete() {
		displayModal(true);
		$("div#modal div.container a.close").click(function() {
			displayModal(false);
			return false;
		});
	}
}
 
//���[�_���E�B���h�E���J��
function displayModal(sign) {
	if (sign) {
		$("div#modal").fadeIn(500);
	} else {
		$("div#modal").fadeOut(250);
	}
}
 
//�E�B���h�E�̈ʒu���Z���^�[�ɒ���
function adjustCenter(target) {
	var margin_top = ($(window).height()-$(target).height())/2;
	var margin_left = ($(window).width()-$(target).width())/2;
	$(target).css({top:margin_top+"px", left:margin_left+"px"});
}
