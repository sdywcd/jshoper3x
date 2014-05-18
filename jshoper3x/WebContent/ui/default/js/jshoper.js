/**
jshoper 中所有的js方法定义
**/
$(function() {
    /**
     * 首页图片播放插件
     */
    myJFlow = function() {
        $("#myController").jFlow({
            controller: ".control", // must be class, use . sign
            slideWrapper: "#jFlowSlider", // must be id, use # sign
            slides: "#slider", // the div where all your sliding divs are nested in
            selectedWrapper: "jFlowSelected", // just pure text, no sign
            width: "1176px", // this is the width for the content-slider
            height: "480px", // this is the height for the content-slider
            duration: 400, // time in miliseconds to transition one slide
            prev: ".slidprev", // must be class, use . sign
            next: ".slidnext", // must be class, use . sign
            auto: true
        });
    },
    myJFlow();
    $('#list_product').carouFredSel({
        prev: '#prev_c1',
        next: '#next_c1',
        auto: false
    });
    $('#list_product2').carouFredSel({
        prev: '#prev_c2',
        next: '#next_c2',
        auto: false
    });
    $(window).resize();
    $("button").click(function() {
        $(this).addClass('click')
    });
});
//========================================jshoper js beigin ==========================================
//========================================jshoper goodscategorylist js ==========================================
$(function() {
    // 获取url地址用来让用户登录时跳转
    var windowsurl = window.location;
    $('#hidurl').attr("value", windowsurl);
});
$(function() {
    // 获取url地址用来让用户登录时跳转
    redirect = function(basepath) {
        var url = window.location.search;
        if (url == "") {
            var redirecturl = "/index.html";
            self.location = basepath + redirecturl;
        } else {
            var redirecturl = url.substring(url.indexOf("?") + 13, url.length);
            if (redirecturl === "") {
                self.location = basepath + "/index.html";
            } else {
                self.location = basepath + "/" + redirecturl;
            }
        }
    },
    //========================================jshoper ocart js ==========================================
    /*
     *将商品加入购物车
     */
    addgoodstocart = function() {
        var needquantity = $("#needquantity").val();
        if (needquantity <= 0) {
            return false;
        }
        var goodsid = $("#hidgoodsid").val();
        var hidurl = $('#hidhtmlpath').val();
        var orderTag = "1"; //普通商品
        $.post("addCart.action", {
            "goodsid": goodsid,
            "needquantity": needquantity,
            "hidurl": hidurl,
            "orderTag": orderTag
        }, function(data) {
            if (!data.slogin) {
                // 跳转到登录页面
                window.location.href = data.basePath + "/html/default/shop/user/login.html?redirecturl=" + hidurl;
            } else {
                if (data.sucflag) {
                    // 跳转到购物车页面
                    window.location.href = "findAllCartByMemberId.action?orderTag=" + orderTag;
                } else {
                    // 跳转到登录页面
                    window.location.href = data.basePath + "/html/default/shop/user/login.html?redirecturl=" + hidurl;
                }
            }
        });
    },
    /*
     *绑定click事件到购物车到动作
     */
    $("#addtocartlink").bind("click", function() {
        addgoodstocart();
    });
    /*
     *绑定click事件到购物车继续购物按钮
     */
    $("#goonshopping").bind("click", function() {
        var basepath = $("#hidbasepath").val();
        if (basepath !== "") {
            // 跳转到商品页面
            window.location.href = basepath + "/index.html";
        }
    });
    /*
     *绑定click事件到购物车刷新列表按钮
     */
    $("#refreshcart").bind("click", function() {
        var url = window.location.search;
        window.location.href = url;
    });
    /*
     *绑定click事件到购物车刷新列表按钮
     */
    $("#mycartlink").bind("click", function() {
        var basepath = $("#hidbasepath").val();
        if (basepath !== "") {
            // 跳转到购物车页面
            window.location.href = "findAllCartByMemberId.action?orderTag=1";
        }
    });
    /*
     * 删除购物车商品根据购物车唯一id
     * */
    delCartByid = function(id) {
        var hidurl = $('#hidurl').val();
        var orderTag = "1"; //普通商品
        $.post("delCartByid.action", {
            "id": id,
            "redirecturl": hidurl
        }, function(data) {
            if (!data.slogin) {
                // 跳转到登录页面
                window.location.href = data.basePath + "/html/default/shop/user/login.html?redirecturl=" + hidurl;
            } else if (data.sucflag) {
                // 跳转到购物车页面
                window.location.href = "findAllCartByMemberId.action?orderTag=" + orderTag;
            } else {
                // 跳转到商品页面
                window.location.href = data.hidurl;
            }
        });
    },
    //========================================jshoper order js ==========================================
    /*
     * 购物车结算并调用初始化订单方法
     * */
    gotojiesuan = function() {
        var hidurl = $('#hidurl').val();
        var hidgoodsid = "";
        var needquantity = 0;
        var sendstring = "";
        var orderTag = "1"; //表示普通商品
        $("input:text").each(function() {
            if (!this.id.indexOf("amount") > 0) {
                needquantity = this.value;
                hidgoodsid = this.id.substring(this.name.indexOf("amount") + 6, this.id.length);
                sendstring += "" + hidgoodsid + "," + needquantity + ":";
            }
        });
        if (sendstring == "") {
            alert("购物车中没有商品请继续购物");
            return false;
        }
        $.post("PlusCartNeedquantityByGoodsid.action", {
            "sendstring": sendstring
        }, function(data) {
            if (data.slogin) {
                //跳转到登录页面
                window.location.href = "user/login.html?redirecturl=" + hidurl;
            }
            if (data.sucflag) {
                //跳转到购物车页面
                window.location.href = "initOrder.action?redirecturl=findAllCartByMemberId.action&orderTag=1";
            }
        });
    },
    /*
     * 绑定购物车结算动作
     * */
    $("#gotojiesuan").bind("click", function() {
        gotojiesuan();
    });
    /*
     * 初始化地区选择插件
     * */
    if ($("#ChinaArea").length > 0) {
        $("#ChinaArea").jChinaArea({
            aspnet: false,
            s1: "上海市", // 默认选中的省名
            s2: "上海市", // 默认选中的市名
            s3: "黄浦区" // 默认选中的县区名
        });
    }
    initpayandtoaddorder = function() {
        var hidurl = $('#hidurl').val();
        var paymentid = $('input[name="paymentid"]:checked').val();
        var logisticsid = $('input[name="logisticsid"]:checked').val();
        var freight = $('#goodsfreightprice').html();
        var deliveraddressid = $('input[name="checkaddress"]:checked').val();
        var customernotes = $('#customernotes').val();
        var logisticswebaddress = $('#hd' + logisticsid).val();
        var cartid = $('#cartid').val(); //购物车id
        if(cartid===""){
            alert("参数错误");
            return false;
        }
        var total = $('#goodstotalprice').html(); //表示商品总金额，不包含运费
        var totalpoints = $("#goodstotalpoints").html(); //总积分
        var cartgoodsid = $("#cartgoodsid").val(); //购物车中商品id
        var cartgoodsname = $("#cartgoodsname").val(); //-购物车中商品名称集合cartgoodsname
        var cartneedquantity = $("#cartneedquantity").val(); //购物车中所有商品数量总和
        if (logisticsid == null) {
            alert("请选择配送方式");
            return;
        }
        if (deliveraddressid == null) {
            alert("请选择 收获地址");
            return;
        }
        if (paymentid != null) {
            $.post("InitAlipayneedInfo.action", {
                "cartneedquantity": cartneedquantity,
                "cartgoodsname": cartgoodsname,
                "cartgoodsid": cartgoodsid,
                "totalpoints": totalpoints,
                "total": total,
                "freight": freight,
                "cartid": cartid,
                "paymentid": paymentid,
                "logisticsid": logisticsid,
                "addressid": deliveraddressid,
                "logisticswebaddress": logisticswebaddress,
                "customernotes": customernotes,
                "orderTag": "1"
            }, function(data) {
                if (!data.slogin) {
                    //跳转到登录页面
                    window.location.href = data.basePath + "/html/default/shop/user/login.html?redirecturl=" + hidurl;
                    return false;
                }
                if (!data.spayment) {
                    alert("支付方式获取失败");
                    return;
                }
                if (!data.saddorder) {
                    alert("订单生成出错");
                    window.location.href = "user/login.html";
                } else {
                    //增加发票到发票记录表
                    var inv_Payee = $('#inv_payee').val();
                    var orderid = data.serialidorderid;
                    var inv_Type = $('#inv_type').val();
                    var amount = $('#shouldtotalprice').text();
                    if (inv_Payee == "" || inv_Payee == undefined) {
                        if (data.paymentcode == "cft" && data.paymentinterface == "3") {
                            //此情况表示财付通
                            window.location.href = data.basePath +"/pay/tenpay/payRequest.jsp";
                        }
                        if (data.paymentcode == "zfb" && data.paymentinterface == "3") {
                            //此情况表示支付宝
                            window.location.href =data.basePath + "/pay/alipay/alipayto.jsp";
                        }
                    } else {
                        $.post("addOrderInvoice.action", {
                            "orderid": orderid,
                            "invType": inv_Type,
                            "invPayee": inv_Payee,
                            "amount": amount,
                            "invContent": "0"
                        }, function(data) {
                            if (data.saddflag) {
                                if (data.paymentcode == "cft" && data.paymentinterface == "3") {
                                    //此情况表示财付通
                                    window.location.href = data.basePath +"/pay/tenpay/payRequest.jsp";
                                }
                                if (data.paymentcode == "zfb" && data.paymentinterface == "3") {
                                    //此情况表示支付宝
                                    window.location.href = data.basePath +"/pay/alipay/alipayto.jsp";
                                }
                            } else {
                                alert("发票提交有误请联系客服处理开发票事宜");
                                if (data.paymentcode == "cft" && data.paymentinterface == "3") {
                                    //此情况表示财付通
                                    window.location.href = data.basePath +"/pay/tenpay/payRequest.jsp";
                                }
                                if (data.paymentcode == "zfb" && data.paymentinterface == "3") {
                                    //此情况表示支付宝
                                    window.location.href = data.basePath +"/pay/alipay/alipayto.jsp";
                                }
                            }
                        });
                    }
                }
            });
        } else {
            alert("请选择支付方式");
        }
    },
    $("#submitorder").bind("click", function() {
        initpayandtoaddorder();
    });
    //========================================jshoper user address js ==========================================
    /*
     * 增加收货地址
     * */
    addnewaddress = function() {
        var hidurl = $('#hidurl').val();
        var membername = $('#membername').val();
        //此处添加收货人信息
        var country = $("#country").find("option:selected").text();
        var province = $('#province').find("option:selected").text();
        var city = $('#city').find("option:selected").text();
        var district = $('#district').find("option:selected").text();
        var street = $('#street').val();
        var mobile = $('#mobile').val();
        var telno = $('#telno').val();
        var email = $('#email').val();
        var postcode = $('#postcode').val();
        if (membername === "" && street === "" && mobile === "") {
            $("#addressmsg").text("请填写收货信息");
            return false;
        }
        $.post("addDeliveraddress.action", {
            "membername": membername,
            "country": country,
            "province": province,
            "city": city,
            "district": district,
            "street": street,
            "mobile": mobile,
            "telno": telno,
            "email": email,
            "postcode": postcode
        }, function(data) {
            if (data.slogin) {
                //跳转到登录页面
                window.location.href = "user/login.html?redirecturl=" + hidurl;
                return false;
            }
            if (data.sucflag) {
                window.location.href = "getUserDeliverAddress.action";
            }
        });
    },
    /*
     * 保定增加收货地址
     * */
    $("#savemyaddress").bind("click", function() {
        addnewaddress();
    });
    //========================================jshoper login js ==========================================
    login = function() {
        var username = $('#username').val();
        if (username === "") {
            $("#errormsg").text("请输入用户名");
            return false;
        }
        var password = $('#password').val();
        if (password === "") {
            $("#errormsg").text("请输入密码");
            return false;
        }
        $.post("login.action", {
            "loginname": username,
            "loginpwd": password
        }, function(data) {
            if (data.loginflag) {
                redirect(data.basePath);
            } else {
                $("#errormsg").text("用户名或密码不正确");
            }
        });
    },
    $("#tologin").bind("click", function() {
        login();
    });
});