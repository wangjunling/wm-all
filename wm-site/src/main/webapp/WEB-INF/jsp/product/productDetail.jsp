<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<!-- end/slide -->
<div class="wcont navibg">
	<div class="bdWrp">
		<div class="navibar clearfix">
			<a class="navilk fl" href="#"> 首页 </a> <i class="icnarrow fl"> </i> <a
				class="navilk fl" href="#" id="category1">  </a> <i
				class="icnarrow fl"> </i> <a class="navilk fl" href="#"
				id="category2">  </a> <i class="icnarrow fl"> </i> <a
				class="navilk fl" href="list.html" id="category3">  </a> <i
				class="icnarrow fl"> </i> <span class="navitxt fl" id="productName">
				 </span>
		</div>
	</div>
</div>
<div class="wcont">
	<div class="bdWrp">
		<div class="dttopcont clearfix">
			<div class="dtlcon fl">
				<div class="picslide" id="ifocus">

					<div id="ifocus_pic">
						<div id="ifocus_piclist" style="left: 0; top: 0;">
							<ul id="picUl">
							</ul>
						</div>

					</div>

					<div id="ifocus_btn">
						<ul class="sld_btnbg" id="btnUl">
						</ul>
					</div>


				</div>
				<!-- end/picslide -->
			</div>
			<!-- end/dtlcon -->

			<div class="dtinfo fl">
				<div class="gdname" id="productTitle"></div>
				<div class="gdexp">
					<span class="clorgn"> </span><span class="clorgn"> </span><span
						class="clorgn"> </span>
					<p class="gdextxt"></p>
				</div>
		
					
				<div class="gdinfo">
					<div class="gdinfobg clearfix">
						<label class="gdtabtit fl"> 众才价 </label> <span class="price">
							面议 </span>
					</div>
					<div class="gdinfobg clearfix">
						<label class="gdtabtit fl"> 商品编号 </label> <span class="price"
							id="num"> 2153358-641 </span>
					</div>
					<div class="gdinfobg clearfix">
						<!--  <label class="gdtabtit fl"> 选择样式 </label> 
						  <span class="gdstyle curgd"> <i class="cured"> </i> 浴缸龙头</span> <span class="gdstyle"> 淋浴龙头</span>	-->
					</div>
					<div class="gdinfobg gdnumbg clearfix">
						<label class="gdtabtit fl"> 数量 </label>
						<div class="clearfix fl">
							<a class="numadd fl" onclick="reduce()"> - </a> <input
								type="text" id="count" class="gdnumbs fl" value="1"
								onblur="modify()" onkeyup="modify()" /> <a class="nummenus fl"
								onclick="add()"> + </a>
						</div>
					</div>


				</div>
				<div class="gdnumbtns">
					<div class="gdinfobg clearfix">
						<div class="gdbtnsbg fl clearfix">
							<a class="btnbuy fl" onclick="buyNow()"> <i
								class="icon_pic icon_buy"> </i> 立即购买
							</a> <a class="btncarts fl" onclick="addOrder()">
                            <i class="icon_pic icon_cart"> </i> 加入采购单
							</a>
						</div>
					</div>

				</div>

			</div>

		</div>

		<div class="dtccont clearfix">
			<div class="dtcleft fl" id="comment">
				<div class="gddttitbg" >
					<a class="gddtctab gddtabcur" onclick="tabs('#comment',0)"> 详细信息 </a> <a class="gddtctab" onclick="tabs('#comment',1)">规格参数
					</a>
					<!--  <a class="gddtctab"> 交易动态 </a>-->
				</div>
				<div class="gddtcont" id="description" style="display: block;"></div>
				<div class="gddtcont" id="parameter" style="display: none">
					<div class="gdbgconwrp">
						<div class="gdtbgtit" id="parBody">主体</div>
				
					</div>

					<div class="gdbgconwrp">
						<div class="gdtbgtit" id="specTheme">规格</div>
				<!--  	<div class="gdtbgcont last clearfix">
							<div class="gddtxtbg">西门子开关插座面西门子开关插座面西门子开关插座面西门子开关插座面</div>
						</div>-->	
					</div>
				</div>
			</div>
			<div class="dtcright fr" id="browse">
				<div class="gddttitbg">最近浏览</div>

			</div>
		</div>
	</div>
</div>
<div class="graycont"></div>


<!-- JQ slider  -->
<script type="text/javascript" src="/resources/js/productDetail.js"></script>
<script type="text/javascript">
var isSingnedIn ='';
jQuery(document).ready(function($) {
	isSingnedIn = ${isSingnedIn};
});
</script>
