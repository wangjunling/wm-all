/* ========================================================


 * ========================================================
 * Copyright 2015 lishanzhou
 *

 * ======================================================== */



$(document).ready(function() {
    var currentIndex = 0;
	var DEMO; //��������
	var currentID = 0; //ȡ������·��Ķ���ID
	var pictureID = 0; //����ID
	$("#ifocus_piclist li").eq(0).show(); //Ĭ��
	autoScroll();
	$("#ifocus_btn li").hover(function() {
		StopScrolll();
		$("#ifocus_btn li").removeClass("current")//���е�liȥ����ǰ����ʽ������������ʽ
		$(this).addClass("current"); //����������ϵ�ǰ����ʽȥ����������ʽ
		currentID = $(this).attr("id"); //ȡ��ǰԪ�ص�ID
		pictureID = currentID.substring(currentID.length - 1); //ȡ���һ���ַ�
		$("#ifocus_piclist li").eq(pictureID).fadeIn("slow"); //������ʾ
		$("#ifocus_piclist li").not($("#ifocus_piclist li")[pictureID]).hide(); //����������ȫ������
		$("#ifocus_tx li").hide();
		$("#ifocus_tx li").eq(pictureID).show();

	}, function() {
		//������뿪�����ʱ���õ�ǰ�Ķ����ID�Ա����������Զ�ʱ����ͬ��
		currentID = $(this).attr("id"); //ȡ��ǰԪ�ص�ID
		pictureID = currentID.substring(currentID.length - 1); //ȡ���һ���ַ�
		currentIndex = pictureID;
		autoScroll();
	});
	//�Զ�����
	function autoScroll() {
		$("#ifocus_btn li:last").removeClass("current");
		$("#ifocus_tx li:last").hide();
		$("#ifocus_btn li").eq(currentIndex).addClass("current");
		$("#ifocus_btn li").eq(currentIndex - 1).removeClass("current");
		$("#ifocus_tx li").eq(currentIndex).show();
		$("#ifocus_tx li").eq(currentIndex - 1).hide();
		$("#ifocus_piclist li").eq(currentIndex).fadeIn("slow");
		$("#ifocus_piclist li").eq(currentIndex - 1).hide();
		currentIndex++; currentIndex = currentIndex >= 4 ? 0 : currentIndex;
		DEMO = setTimeout(autoScroll, 20000);
	}
	function StopScrolll()//������ƶ������������ʱ��ֹͣ�Զ�����
	{
		clearTimeout(DEMO);
	}
});

