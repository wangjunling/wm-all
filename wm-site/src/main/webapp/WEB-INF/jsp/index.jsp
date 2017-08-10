<%--
  Created by IntelliJ IDEA.
  User: chengpanwang
  Date: 7/1/15
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>

<!doctype html>
<html dir="ltr" lang="zh-CN">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title> 材易得 </title>
    <meta name="description" content="材易得"/>
    <meta name="keywords" content="材易得 云商城 材材 采购"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
    <meta name="Author" content="cloud assistant"/>
    <link rel="shortcut icon" href="/resources/img/zc-ico-48.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/resources/css/base.css"/>
    <link rel="stylesheet" href="/resources/css/style.css"/>


    <!-- script area -->
    <script type="text/javascript" src="/resources/js/jquery-1.7.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#searchBtn').on('click', function () {
                var keyWord = $.trim($('[name="keyWord"]').val());
                if (keyWord) {
                    location.href = '/product/search.htm?keyWord=' + encodeURI(keyWord);
                }
            });


            $('body').on('keydown', function (e) {
                var code = e.which;
                if (code == 13) {
                    var keyWord = $.trim($('[name="keyWord"]').val());
                    if (keyWord) {
                        $('form').submit();
                    }
                }
            });

        });


    </script>
    <!-- /script area -->

</head>
<body class="bodynormal">

<!-- hd -->
<div class="inte-header">
    <div class="top-icos">
        <ul class="sns">
            <li class="qq"><a href="#"></a></li>
            <li class="weibo"><a href="#"></a></li>
            <li class="mail"><a href="#"></a></li>
            <li class="link"><a href="#"></a></li>
        </ul>
        <a href="/home.htm" class="logo"></a>

        <div class="search">
            <p class="links">
                <a class="signup" href="/register.htm">注册</a>
                <a class="acount" href="/buyer/profile.htm">我的账户</a>
                <a class="purchase" href="/order/orderList.htm">采购单</a>
            </p>

            <form action="/product/search.htm" method="get">
                <input type="text" class="search-btn" placeholder="搜索" name="keyWord">
                <i class="submit-ico" id="searchBtn"></i>
            </form>
        </div>
    </div>
    <div class="nav">
        <ul>
            <li><a href="/home.htm">众材首页</a></li>
            <li><a href="#">关于我们</a></li>
            <li><a href="#">项目案例</a></li>
            <li><a href="#">联系我们</a></li>
            <li><a href="#">集中采购</a></li>
        </ul>
    </div>
</div>
<!-- /hd -->
<!-- integration -->
<div class="integration">
    <div class="banner"></div>
    <div class="wrapper">
        <h2>整合有力</h2>

        <div class="description">凭借对红星美凯龙数百工程项目经验的积累，规范的采购体系，严格的质量标准，和多元化的人才结构，决定了众才网可以为客户提供高效、准确、快速的解决方案</div>
        <div class="next"></div>
        <div class="avator-list">
            <div class="avator">
                <div class="img">
                    <img src="/resources/images/integration01.png" alt="">
                </div>
                <div class="infos">
                    <div class="title">
                        <h4>设计优化</h4>

                        <p class="sub">Construction Design Optimization</p>
                        <a href="#" class="more">more...</a>
                    </div>
                    <p class="detail">结合实际情况优化了前期设计稿，给施工方提供了更加节省和高效的方案，为按时完成工期节约成本做出了巨大的贡献</p>
                </div>
            </div>
            <div class="avator">
                <div class="img">
                    <img src="/resources/images/integration02.png" alt="">
                </div>
                <div class="infos">
                    <div class="title">
                        <h4>工程咨询</h4>

                        <p class="sub">Construction Project Consultation</p>
                        <a href="#" class="more">more...</a>
                    </div>
                    <p class="detail">结合实际情况优化了前期设计稿，给施工方提供了更加节省和高效的方案，为按时完成工期节约成本做出了巨大的贡献</p>
                </div>
            </div>
            <div class="avator">
                <div class="img">
                    <img src="/resources/images/integration03.jpg" alt="">
                </div>
                <div class="infos">
                    <div class="title">
                        <h4>集中采购</h4>

                        <p class="sub">Centralized Purchasing</p>
                        <a href="#" class="more">more...</a>
                    </div>
                    <p class="detail">结合实际情况优化了前期设计稿，给施工方提供了更加节省和高效的方案，为按时完成工期节约成本做出了巨大的贡献</p>
                </div>
            </div>
        </div>
    </div>
    <div class="zc-motto"></div>
    <div class="sub-wrapper">
        <h4 class="title">实力无可比拟</h4>

        <p class="sub-title">有一个平台始终被全国的采购商采用，影响着整个行业，领导着整个行业，做到始终品质如一</p>

        <div class="keywords">
            <div class="cell">
                <h4 class="key-title a">超值平台服务</h4>

                <p class="detail">交付后的保洁服务，针推性的推送特价商品，专家团队免费的设计、规划等服务</p>
            </div>
            <div class="cell">
                <h4 class="key-title b">优质的供应商</h4>

                <p class="detail">多年合作积累下的金牌优质供应商，为采购提供高质量的产品与服务</p>
            </div>
            <div class="cell">
                <h4 class="key-title c">优化采购流程</h4>

                <p class="detail">整个采购流程，只需要一名专职人员全程对接，节省至少20%的成本</p>
            </div>
            <div class="cell">
                <h4 class="key-title d">超全商品品类</h4>

                <p class="detail">庞大的供应商团队，保障品类齐全，一站式采购体验，方便轻松快捷</p>
            </div>
        </div>
    </div>
    <a href="#" class="realize-more">了解我们更多...</a>
</div>
<!-- /integration -->

<!-- end/cont -->

<div class="wcont footer">
    <div class=" bdWrp">
        <div class="ftslogan"> 领先的一站式服务平台</div>
        <div class="frdlkwrp">
            <a class="frdlk" href="#"> 关于我们 </a>
            <a class="frdlk" href="#"> 联系我们 </a>
            <a class="frdlk" href="#"> 客服中心 </a>
            <a class="frdlk" href="#"> 法律声明 </a>
            <a class="frdlk" href="#"> 会员协议 </a>
            <a class="frdlk" href="#"> 隐私策略 </a>
            <a class="frdlk last" href="#"> 站点地图 </a>
        </div>
        <div id="copyright">
            Copyright © 2015 材易得版权所有 <span class="cplks"> 备案证书号：沪ICP备888888号 </span>
            <span class="cplks"> 经营许可证编号：沪B2-999999 </span>
        </div>
    </div>
</div>


<!-- JQ slider  -->

</body>
</html>