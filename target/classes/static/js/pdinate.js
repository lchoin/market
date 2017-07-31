/**
 * Created by 婵 on 2017/2/8.
 */
var TokenID=localStorage.getItem("TokenID");
$(function(){
    /*置顶*/
    $(window).scroll(function(){
        if($(window).scrollTop()>100){
            $("#gotop").fadeIn(400);
        }else{
            $("#gotop").fadeOut(400);
        }
    });
    $("#gotop").click(function(){
        $("body,html").animate({scrollTop:0},200);
        return false;

    });
    /*底部*/
    $(".submenu li").off("click");
    $(".submenu li").on("click",function(){
        $(".submenu li").removeClass("active");
        if(!$(this).hasClass("active")){
            $(this).addClass("active");
            $(this).parent().parent().addClass("active");
            var url=$(this).children().attr("url");
            $(".content-all").load(url);
        }
    });
    onlis();
    /*商品详情*/
    $(".clear>div").on("click",function(){
        $(this).parent().children().removeClass("active");
        $(this).addClass("active");
    });
});
/*默认点击*/
function indes(quick,num){
    num= num || 0;
    $(quick).eq(num).trigger("click");
};
function onlis(){
    var url=sessionStorage.getItem("num");
    if(url==null){
        indes(".submenu li");
    }else{
        indes(".submenu li",url);
    }
};
function returnload(num){
    var id=sessionStorage.getItem("buyId");
    sessionStorage.removeItem(id);
    sessionStorage.removeItem("num");
    sessionStorage.removeItem("detailId");
    sessionStorage.removeItem("buyId");
    sessionStorage.removeItem("commentId");
    window.location.href="/phone/index.html";
    sessionStorage.setItem("num",num);
};
/*---------------------*/
//登录
function loginData(){
    sessionStorage.removeItem("num");
    localStorage.removeItem("TokenID");
    var username=$(".load-bot1 input[name='username']").val();
    var password=$(".load-bot1 input[name='password']").val();
    if(username==""){
        alert("请输入账号");
    }else if(password==""){
        alert("请输入密码");
    }else{
        $.post("/TbUserApp/ajaxLogin",{
            "username":username,
            "password":password
        },function(data){
            if(data.status==1){
                localStorage.setItem("TokenID",data.TokenID);
                /*window.open('/phone/index.html',"_self");*/
                returnload(3);
            }else{
                $(".message").css("display","block");
                $(".message").text(data.message);
            }
        });
    }
};
/*获取验证码*/
function getCode(title,id,btns){
    var phone=$(title).val();
    console.log(phone);
    if(phone==""){
        layer.open({
            content: "请输入手机号码"
            ,skin: 'msg'
            ,time: 2
        });
    }else {
        $.post("/TbUserApp/obtainVerificationCode",{
            phone:phone,
            type:id
        },function(data){
            console.log(data);
            if(data.status==1){
                time(btns);
            }else if(data.status==-1){
                layer.open({
                    content: data.message,
                    skin: 'msg'
                    ,time: 2
                });
            }else if(data.status==0){
                layer.open({
                    content: "发送失败"
                    ,skin: 'msg'
                    ,time: 2
                });
            }
        });
    }
};
//
var wait=60;
function time(btns) {
    if (wait == 0) {
        $(btns).attr("disabled",false);
        $(btns).val("获取验证码")
        wait = 60;
    } else {
        $(btns).attr("disabled", true);
        $(btns).val("已发送")
        wait--;
        setTimeout(function() {
                time(btns)
            },
            1000)
    }
};
/*忘记密码*/
function forgetPwd(){
    var account=$("input[name='account']").val();
    var pass=$("input[name='pass']").val();
    var verificationCode=$("input[name='verificationCode']").val();
    if(account==""){
        layer.open({
            content: "请输入手机号码"
            ,skin: 'msg'
            ,time: 2
        });
    }else if(pass==""){
        layer.open({
            content: "请输入密码"
            ,skin: 'msg'
            ,time: 2
        });
    }else if(verificationCode==""){
        layer.open({
            content: "请输入验证码"
            ,skin: 'msg'
            ,time: 2
        });
    }else{
        $.post("/TbUserApp/forgetPassByAccount",{
            account:account,
            pass:pass,
            verificationCode:verificationCode
        },function(data){
            if(data.status=="1"){
                layer.open({
                    content: data.message,
                    btn:"确定",
                    yes:function(){
                        window.location.href="/phone/plogin.html";
                    }
                });
            }else{
                layer.open({
                    content: data.message,
                    skin: 'msg'
                    ,time: 2
                });
            };
        });
    };
};
/*注册*/
function checkeregister(){
    var uPhone=$("input[name='uPhone']").val();
    if(uPhone==""){}else{
        $.post("/TbUserApp/isRegister",{
            phone:uPhone
        },function(data){
            if(data.status==0){
                layer.open({
                    content: "用户已注册"
                    ,skin: 'msg'
                    ,time: 2
                });
            }
        })
    }
};
function registerUser(){
    var uPhone=$("input[name='uPhone']").val();
    var uPassword=$("input[name='uPassword']").val();
    var uReisterRecommenderAccount=$("input[name='uReisterRecommenderAccount']").val();
    var verificationCode=$("input[name='verificationCode']").val();
    if(uPhone==""){
        layer.open({
            content: "请输入手机号码"
            ,skin: 'msg'
            ,time: 2
        });
    }else if(uPassword==""){
        layer.open({
            content: "请输入密码"
            ,skin: 'msg'
            ,time: 2
        });
    }else if(verificationCode==""){
        layer.open({
            content: "请输入验证码"
            ,skin: 'msg'
            ,time: 2
        });
    }else {
        $.post("/TbUserApp/registerByPhone",{
            uPhone:uPhone,
            uPassword:uPassword,
            uReisterRecommenderAccount:uReisterRecommenderAccount,
            verificationCode:verificationCode
        },function(data){
            if(data.status==1){
                layer.open({
                    content: data.message,
                    btn:"确定",
                    yes:function(){
                        window.location.href="/phone/plogin.html";
                    }
                });
            }else{
                layer.open({
                    content: data.message,
                    skin: 'msg'
                    ,time: 2
                });
            };
        });
    };
};
function clearMessage(){
    $(".message").css("display","none");
};
//退出
function logout() {
    var TokenID=localStorage.getItem("TokenID");
    $.post("/TbUserApp/ajaxLogout",{
        TokenID:TokenID
    },function(data){
        localStorage.removeItem("TokenID");
        indes(".submenu li",0);
    })
};
//跳转页面
function loadPages(id){
    $.get("/TbUserApp/selectMe",{
        TokenID:TokenID
    },function(data){
        if(data.status=="0"){
            layer.open({
                content: '您好！请登陆'
                ,skin: 'msg'
                ,time: 3
            });
        }else{
            var url=$(id).attr("url");
            window.location.href=url;
        }
    });
};
//时间
function dateUtil(value){
    var date = new Date(value);
    return date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日  "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
};
/*---------------------------*/
/*个人中心*/
function lo1(){
    window.location.href='plogin.html'
}
function showMessage1(){
    $.get("/TbUserApp/selectMe",{
        TokenID:TokenID
    },function(data){
        if(data.status=="0"){
            $(".lis").append("<div class='tops' style='position: relative;height:100%;text-align: center' onclick='lo1()'><div class='igl' style='margin-right: -25px;'> <img src='/images/icon8_2.png'></div><div class='plog'>你好，请登录</div> </div>  ")
        }else{
            $(".lis>div").removeClass("none");
            if(data.tbUser.uHeadPortrait!=null){
                $(".igl img").attr("src","/image/getImg?path="+data.tbUser.uHeadPortrait);
            };
            var uAuthentication;
            if(data.tbUser.uAuthentication==0){
                uAuthentication="未认证";
            }else if(data.tbUser.uAuthentication==1){
                uAuthentication="已认证";
                $(".thud").off("click");
                $(".thud").attr("url","index.html");
                $(".thud").on("click",function(){
                    layer.open({
                        content: "您已认证"
                        ,skin: 'msg'
                        ,time: 3
                    });
                })
            }
            $(".userName").text(data.tbUser.uName);
            $(".uAuthentication").text(uAuthentication);

        }
    });
};
/*个人资料*/
function loadPerInfo(){
    $.get("/TbUserApp/selectMe",{
        TokenID:TokenID
    },function(data){
        console.log(data);
        var uAuthentication;
        if(data.tbUser.uAuthentication==0){
            uAuthentication="未认证";
            $(".uAuthDate").text("");
        }else if(data.tbUser.uAuthentication==1){
            uAuthentication="已认证";
            $(".uAuthDate").text(dateUtil(data.tbUser.uAuthDate));
        }
        $(":text[name='uName']").val(data.tbUser.uName);
        $(":text[name='uHeadPortrait']").val(data.tbUser.uHeadPortrait);
        $(".uAccount").text(data.tbUser.uAccount);
        $(":input[name='uPhone']").val(data.tbUser.uPhone);
        if(data.tbUser.uSex == "1"){
            //男
            $(".man").prop({checked: true});
        }else{
            //女
            $(".feman").prop({checked: true});
        }
        $(":text[name='uProvince']").val(data.tbUser.uProvince);
        $(":text[name='uCity']").val(data.tbUser.uCity);
        $(":text[name='uAddress']").val(data.tbUser.uAddress);
        $(".uCreateDate").text(dateUtil(data.tbUser.uCreateDate));
        $(".uAuthentication").text(uAuthentication);
        $(".uReisterRecommender").text(data.tbUser.uReisterRecommender);
        $(".uReisterRecommenderAccount").text(data.tbUser.uReisterRecommenderAccount);
        $("textarea[name='uRemark']").val(data.tbUser.uRemark);

    })
};
/*修改个人资料*/
function modifyPerInfo(){
    var uName=$(":text[name='uName']").val();
    var uHeadPortrait=$(":text[name='uHeadPortrait']").val();
    var uPhone=$(":input[name='uPhone']").val();
    var uSex=$(":radio[name='uSex']:checked").val();
    var uProvince=$(":text[name='uProvince']").val();
    var uCity=$(":text[name='uCity']").val();
    var uAddress=$(":text[name='uAddress']").val();
    var uRemark=$("textarea[name='uRemark']").val();
    $.post("/TbUserApp/updateMe",{
        uName:uName,
        uHeadPortrait:uHeadPortrait,
        uPhone:uPhone,
        uSex:uSex,
        uProvince:uProvince,
        uCity:uCity,
        uAddress:uAddress,
        uRemark:uRemark,
        TokenID:TokenID
    },function(data){
        layer.open({
            content: data.message,
            btn:"关闭",
            yes :function () {
                if(data.status==1){
                    returnload(3)
                }
            }
        });
    });
};
/*修改头像*/
function modifyHead() {
    var formData = new FormData($("#frmUpload1")[0]);
    $.ajax({
        url: '/image/upload',
        type: 'POST',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function(data){
            if(data.status == 1){
                $("#uhead1").attr({ src: "/image/getImg?path="+data.filePath});
                $("#picture1").val(data.filePath);
                var uHeadPortrait=$(":text[name='uHeadPortrait']").val();
                updateUserInfo(uHeadPortrait);
            }
        },
        error: function(){
            layer.open({
                content: "与服务器通信发生错误",
                skin: 'msg'
                ,time: 2
            });
        }
    });

};
function updateUserInfo(uHeadPortrait){
    $.get("/TbUserApp/updateMe",{
        uHeadPortrait:uHeadPortrait,
        TokenID:TokenID
    },function(data){
        if(data.status==1){
            layer.open({
                content: data.message,
                skin: 'msg'
                ,time: 3
            });
            returnload(3);
        }else{
            layer.open({
                content: data.message,
                skin: 'msg'
                ,time: 3
            });
        };
    });
};
//修改密码
function modifyPwd(){
    var oldPasswd=$("input[name='oldPasswd']").val();
    var passwd=$("input[name='passwd']").val();
    var passwd2=$("input[name='passwd2']").val();
    if(passwd!=passwd2){
        layer.open({
            content: "两次密码不一致，请重新输入"
            ,skin: 'msg'
            ,time: 3
        });
    }else if(oldPasswd==""){
        layer.open({
            content: "请输入旧密码"
            ,skin: 'msg'
            ,time: 3
        });
    }else {
        $.post("/TbUserApp/updatePass",{
            oldPasswd:oldPasswd,
            passwd:passwd,
            passwd2:passwd2,
            TokenID:TokenID
        },function(data){
            layer.open({
                content: data.message,
                btn:"关闭",
                yes :function () {
                    if(data.status==1){
                        returnload(3)
                    }
                }
            });
        });
    }
};
//充值中心
function reCharges() {
    var uAccount=$("input[name='uAccount']").val();
    var money=$("input[name='money']").val();
    if(uAccount==""){
        alert("请输入账号");
    }else if(money==""){
        alert("请输入充值金额");
    }else{
        $.post("/TbUser/recharge",{
            uAccount:uAccount,
            money:money
        },function(data){
            alert(data.message);
        })
    }
};
//查看我的下线
function checkMyLine(num){
    num=num||1;
    $.get("/TbUserApp/selectMember",{
        number:num,
        TokenID:TokenID
    },function(data){
        if(data.tbUsers.length==0){
            $(".contents").children(":gt(0)").remove();
            $(".contents").append("<div style='line-height: 50vh;text-align: center'><img src='/images/nons.png'><h1 style='color:#ccc;text-align: center;'>暂无下线</h1></div>")
        }else {
            $(".contents").children(":gt(0)").remove();
            for(var aus in data.tbUsers){
                var type1;
                if(data.tbUsers[aus].uType==0){
                    type1="普通用户";
                }else if(data.tbUsers[aus].uType==1){
                    type1="银卡会员";
                }else if(data.tbUsers[aus].uType==2){
                    type1="金卡会员";
                }else if(data.tbUsers[aus].uType==3){
                    type1="铂金会员";
                }else if(data.tbUsers[aus].uType==4){
                    type1="普通会员";
                }else if(data.tbUsers[aus].uType==5){
                    type1="管理员";
                };
                var newtr=$(".contents .none").clone().removeClass("none");
                newtr.children().find(".uName").text(data.tbUsers[aus].uName);
                newtr.children().find(".uPhone").text(data.tbUsers[aus].uPhone);
                newtr.children().find(".uType").text(type1);
                newtr.children().find(".uCreateDate").text(dateUtil(data.tbUsers[aus].uCreateDate));
                newtr.children().find(".uReisterRecommender").text(data.tbUsers[aus].uReisterRecommender);
                newtr.children().find(".uSumMoney").text(data.tbUsers[aus].uSumMoney);
                $(".contents").append(newtr);
            };
        };

    });
};
//上一个下线
function lastType(){
    var number = $(".numberType").text()-1;
    if(number == 0){
        layer.open({
            content: "已经到底了"
            ,skin: 'msg'
            ,time: 2
        });
        return ;
    }
    $(".numberType").text(number);
    //显示
    checkMyLine(number);

};
//下一个下线
function nextType(){
    var number = parseInt($(".numberType").text())+1;
    if(number==10){
        layer.open({
            content: "已经到底了"
            ,skin: 'msg'
            ,time: 2
        });
    }else {
        $(".numberType").text(number);
        //显示
        checkMyLine(number);
    }
};
//用户认证
function userAuth(){
    var aRealName=$("input[name='aRealName']").val();
    var aIdentityCard=$("input[name='aIdentityCard']").val();
    var aIdentityCardPicture=$("input[name='aIdentityCardPicture']").val();
    var aRemark=$("textarea[name='aRemark']").val();
    if(aRealName==""){
        layer.open({
            content: "请输入姓名"
            ,skin: 'msg'
            ,time: 2
        });
    }else if(aIdentityCard==""){
        layer.open({
            content: "请输入身份证账号"
            ,skin: 'msg'
            ,time: 2
        });
    }else if(aIdentityCardPicture==""){
        layer.open({
            content: "请上传身份证照片"
            ,skin: 'msg'
            ,time: 2
        });
    }else{
        $.post("/TbAuthenticationApp/insert",{
            aRealName:aRealName,
            aIdentityCard:aIdentityCard,
            aIdentityCardPicture:aIdentityCardPicture,
            aRemark:aRemark,
            TokenID:TokenID
        },function(data){
            layer.open({
                content: data.message,
                btn:"关闭",
                yes :function () {
                    if(data.status==1){
                        returnload(3)
                    }
                }
            });
        });
    }
};
//个人消费
function showUserComsum(){
    $.get("/TbConsumptionApp/selectAll",{
            TokenID:TokenID
        },function(data){
            $(".uSumMoney").text(data.sumMoney);
            $(".uUsableMoney").text(data.usableMoney)
            if(data.tbConsumptions.length==0){

            }else{
                $(".newtable").children(":gt(0)").remove();
                for(var tip in data.tbConsumptions){
                    var newtr=$(".newtable .none").clone().removeClass("none");
                    newtr.children().find(".cSource").text(data.tbConsumptions[tip].cSource);
                    newtr.children().find(".cMoney").text(data.tbConsumptions[tip].cMoney);
                    newtr.children().find(".cCreateDate").text(dateUtil(data.tbConsumptions[tip].cCreateDate));
                    newtr.children().find(".cRemark").text(data.tbConsumptions[tip].cRemark);
                    $(".newtable").append(newtr);
                }
            }


        })
};
/*-----------------------------------*/
/*上传图片*/
function uploadFile(t1,t2,t3){
    var formData = new FormData($(t1)[0]);
    $.ajax({
        url: '/image/upload',
        type: 'POST',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function(data){
            $(t2).attr({ src: "/image/getImg?path="+data.filePath});
            $(t3).val(data.filePath);
        },
        error: function(){
            console.log("与服务器通信发生错误");
        }
    });
};
/*--------------------*/
//查看收货地址
function viewAdress() {
    $(".viewAdr").children(":gt(0)").remove();
    $.get("/TbDeliveryAddressApp/selectAll",{
        pageSize:100,
        TokenID:TokenID
    },function(data){
        $("input[type='checkbox']").prop({checked: false});
        for(var len in data.pageInfo.list){
            var def;
            var checkd1;
            if(data.pageInfo.list[len].daIsDefault=="0"){
                def="设置默认";
                checkd1=false;
            }else if(data.pageInfo.list[len].daIsDefault=="1"){
                def="默认地址";
                checkd1=true;
            };
            var newtr=$(".viewAdr .none").clone().removeClass("none");
            newtr.children().find(".daName").text(data.pageInfo.list[len].daName);
            newtr.children().find(".daPhone").text(data.pageInfo.list[len].daPhone);
            newtr.children().find(".daDetailAddress").text(data.pageInfo.list[len].daDetailAddress);
            newtr.children().find(".checked1").text(data.pageInfo.list[len].daId);
            newtr.children().find("input[name='daIsDefault']").prop("checked",+checkd1);
            newtr.children().find(".spinputs").append("<span class='daIsDefault'>"+def+"</span> <div class='delAdress' style='border:1px solid #ccc;padding:5px;float: right' onclick='deleteAdress("+data.pageInfo.list[len].daId+")'>删除</div> ")
            $(".viewAdr").append(newtr);
        };

    });
};
//添加收货地址
function addAdress(){
    var daName=$("#addAdre input[name='daName']").val();
    var daPhone=$("#addAdre input[name='daPhone']").val();
    var daDetailAddress=$("#addAdre input[name='daDetailAddress']").val();
    var daIsDefault=$("#addAdre :radio[name='daIsDefault']:checked").val();
    var daRemark=$("#addAdre textarea[name='daRemark']").val();
    if(daName==""){
        layer.open({
            content: "请输入收件人"
            ,skin: 'msg'
            ,time: 2
        });
    }else if(daPhone==""){
        layer.open({
            content: "请输入手机号码"
            ,skin: 'msg'
            ,time: 2
        });
    }else if(daDetailAddress==""){
        layer.open({
            content: "请输入详细地址"
            ,skin: 'msg'
            ,time: 2
        });
    }else{
        $.post("/TbDeliveryAddressApp/insert",{
            daName:daName,
            daPhone:daPhone,
            daDetailAddress:daDetailAddress,
            daIsDefault:daIsDefault,
            daRemark:daRemark,
            TokenID:TokenID
        },function(data) {
            layer.open({
                content: data.message
                ,skin: 'msg'
                ,time: 2
            });
            if(data.status==1){
                returnload(2);
            }
        });
    }
};
//设置默认
function hasDefualt(th){
    var id=$(th).prev().text();
    $.post("/TbDeliveryAddressApp/settingDefault",{
        daId:id,
        TokenID:TokenID
    },function(data){
        layer.open({
            content: data.message
            ,skin: 'msg'
            ,time:2
        });
        indes(".submenu li",2);
    });
};
//删除收货地址
function deleteAdress(id) {
    $.post("/TbDeliveryAddressApp/deleteById",{
        daId:id,
        TokenID:TokenID
    },function(data){
        layer.open({
            content: data.message
            ,skin: 'msg'
            ,time:2
        });
        indes(".submenu li",2);
    })
};
/*查看购买记录*/
function viewPurCharse() {
    $(".lisr img").attr("src","");
    $(".pusrchar").children(":gt(0)").remove();
    if(TokenID==null){
        $(".pusrchar").append("<div style='line-height: 60vh;text-align: center'><img src='/images/nons.png'><h1 style='color:#ccc;text-align: center;'>暂无购买记录</h1></div>")
    }else{
        $.get("/TbGoodsApp/selectAllByUserId",{
            TokenID:TokenID
        },function(data){
            if(data.tbGoodss.length==0){
                 $(".pusrchar").append("<div style='line-height: 60vh;text-align: center'><img src='/images/nons.png'><h1 style='color:#ccc;text-align: center;'>暂无购买记录</h1></div>")
            }else{
                for(var good in data.tbGoodss){
                    var newtr=$(".pusrchar>.none").clone().removeClass("none");
                    var ids='"'+(data.tbGoodss[good].tbPersonIndent.piId).toString()+'"';
                    var as;
                    if(data.tbGoodss[good].tbPersonIndent.piStatus=="1"){
                        as="等待发货";
                        newtr.children().find(".btn_trems").append("<div style='color:red;padding:7px'>等待发货</div>");
                    }else if(data.tbGoodss[good].tbPersonIndent.piStatus=="2"){
                        as="已发货";
                        newtr.children().find(".btn_trems").append("<div style='border:1px solid #ccc;padding:7px' onclick='confirmReceipt("+ids+")'>确认收货</div>");
                    }else if(data.tbGoodss[good].tbPersonIndent.piStatus=="3"){
                        as="已到货，等待评论";
                        var piId = '"' + data.tbGoodss[good].tbPersonIndent.piId + '"';
                        newtr.children().find(".btn_trems").append("<div style='border:1px solid #ccc;padding:7px' onclick='productReviews1("+piId+")'>评论</div>");
                    }else if(data.tbGoodss[good].tbPersonIndent.piStatus=="4"){
                        as="完成";
                    };
                    newtr.children().find(".creatData").text(dateUtil(data.tbGoodss[good].tbPersonIndent.piCreateDate));
                    newtr.children().find(".purChaseNum span").text(data.tbGoodss[good].tbPersonIndent.piId);
                    newtr.children().find(".imgs").attr("src","/image/getImg?path="+data.tbGoodss[good].tbGoods.gPicture);
                    newtr.children().find(".gName").text(data.tbGoodss[good].tbGoods.gName);
                    newtr.children().find(".gPrice span").text(data.tbGoodss[good].tbGoods.gPrice);
                    newtr.children().find(".count span").text(data.tbGoodss[good].tbPersonIndent.piQuantity);
                    newtr.children().find(".pos").append("<div style='width: 100%;height: 100%;position: absolute;top:0' onclick='viewPurCharse2("+ids+")'></div>");
                    newtr.children().find(".btn_trems").append("<div style='border:1px solid #ccc;padding:7px;text-align: center' onclick='deletePuy("+ids+")'>删除</div>");
                    $(".pusrchar").append(newtr);
                    sessionStorage.setItem(data.tbGoodss[good].tbPersonIndent.piId,JSON.stringify(data.tbGoodss[good]));
                };
            }
        });
    }
};
/*删除购买记录*/
function deletePuy(id){
    layer.open({
        content: '您确定要删除吗？'
        ,btn: ['是', '否']
        ,yes: function(){
            $.post("/TbGoodsApp/deleteByUserId",{
                piid:id,
                TokenID:TokenID
            },function(data){
                layer.open({
                    content: data.message
                    ,skin: 'msg'
                    ,time:2
                });
                indes(".submenu li",1);
            });
        },
        no:function(){layer.close();}
    });

}
/*查看购买详情*/
function viewPurCharse2(id){
    sessionStorage.setItem("buyId",id);
    window.location.href="/phone/record2.html";
};
function loadPur(){
    var buyID=sessionStorage.getItem("buyId");
    var log=JSON.parse(sessionStorage.getItem(buyID));
    window.onload=function(){
        $("#creatData span").text(dateUtil(log.tbPersonIndent.piCreateDate));
        $("#purChaseNum span").text(log.tbPersonIndent.piId);
        $(".imgs").attr("src","/image/getImg?path="+log.tbGoods.gPicture);
        $(".gName").text(log.tbGoods.gName);
        $(".gPrice span").text(log.tbGoods.gPrice);
        $(".count span").text(log.tbPersonIndent.piQuantity);
        var pi;
        if(log.tbPersonIndent.piStatus=="1"){
            pi="等待发货";
        }else if(log.tbPersonIndent.piStatus=="2"){
            pi="已发货";
        }else if(log.tbPersonIndent.piStatus=="3"){
            pi="已到货，等待评论";
        }else if(log.tbPersonIndent.piStatus=="4"){
            $(".wuliu").addClass("none");
            pi="完成";
            $(".frim").append("<div>评论：<span>"+log.tbPersonIndent.piEvaluateLanguage+"</span></div>");
        };
        $(".status span").text(pi);
        $(".pen span").text(log.uName);
        $(".penTel span").text(log.tbPersonIndent.daPhone);
        $(".penAd span").text(log.tbPersonIndent.daDetailAddress);
        $.post("/TbPersonIndentApp/selectExpress",{
            tracking_number:log.tbPersonIndent.piTrackingNumber,
            carrier_code:log.tbPersonIndent.piCarrierCode,
            TokenID:TokenID
        },function(datas){
            $(".wuliu div").remove();
            var wuliu=$.parseJSON(datas.expressCompany).data.items[0].origin_info.trackinfo;
            if(wuliu==null|| wuliu==""){
                $(".wuliu").append("<div><span>暂无物流信息</span></div>")
            }else{
                for(var tip in wuliu){
                    $(".wuliu").append("<div><span style='color:darkred'>"+wuliu[tip].Date+":</span><span style='margin-left: 5px'>"+wuliu[tip].StatusDescription+"</span></div>")
                }
            }

        })
    };
};
//确认收货
function confirmReceipt(id){
    $.post("/TbPersonIndentApp/updateStatusById",{
        'piId':id,
        'piStatus':'3',
        TokenID:TokenID
    },function (data) {
        layer.open({
            content: data.message
            ,skin: 'msg'
            ,time:2
        });
        indes(".submenu li",1);
    });
};
//评论
function productReviews1(id){
    sessionStorage.setItem("commentId",id);
    window.location.href="/phone/pcomments.html";
};
function loadComment(){
    var commentId=sessionStorage.getItem("commentId");
    var log=JSON.parse(sessionStorage.getItem(commentId));
    window.onload=function(){
        $("#creatData span").text(dateUtil(log.tbPersonIndent.piCreateDate));
        $("#purChaseNum span").text(log.tbPersonIndent.piId);
        $(".imgs").attr("src","/image/getImg?path="+log.tbGoods.gPicture);
        $(".gName").text(log.tbGoods.gName);
        $(".gPrice span").text(log.tbGoods.gPrice);
        $(".count span").text(log.tbPersonIndent.piQuantity);
    };
};
//评论提交
function commentSubmit(){
    var commentId=sessionStorage.getItem("commentId");
    var piEvaluateLanguage = $("#piEvaluateLanguage").val();
    var piEvaluateGrade = $('#piEvaluateGrade').val();
    // alert(piEvaluateLanguage + " ; " + piEvaluateGrade + " ; " + pinId);
    if(piEvaluateLanguage==""){
        layer.open({
            content: "请输入评论语",
            skin: 'msg'
            ,time: 2
        });
    }else {
        $.get("/TbGoodsApp/comment",{
            piId:commentId,
            piEvaluateLanguage:piEvaluateLanguage,
            piEvaluateGrade:piEvaluateGrade,
            TokenID:TokenID
        },function(data){
            var commentId=sessionStorage.getItem("commentId");
            if(data.status==1){
                layer.open({
                    content: data.message,
                    btn:"确定",
                    yes:function(){
                        sessionStorage.removeItem(commentId);
                        sessionStorage.removeItem("commentId");
                        returnload(0);
                    }
                });
            }else{
                layer.open({
                    content: data.message,
                    skin: 'msg'
                    ,time: 2
                });
            }
        })
    }

};
//星级评论
function updateGrade(Grade){
    $('#imgul > li').removeClass("active");
    for(var i=0;i<Grade;i++){
        $("#imgul li").eq(i).addClass("active");
    };
    $('#piEvaluateGrade').val(Grade);
};
/*---------购买商品-----------*/
//查找所有商品
function userViewGoods(){
    /*$(".goodsList li").remove();*/
    $.get("/TbGoodsApp/selectAll",function(data){
        for(var k in data.tbGoodss){
            $(".shop").append("<li style='z-index: 1' onclick='viewDetailGooods("+data.tbGoodss[k].gId+")'><div class='goodsList'><div class='sImg'><img src='/image/getImg?path="+data.tbGoodss[k].gPicture+"' alt=''></div><div class='sTitle'><a href='#'> "+data.tbGoodss[k].gName+"</a></div><div class='sPrice'>￥<span>"+data.tbGoodss[k].gPrice+"</span></div></div></li>")
        }
    })
};
//查看详细商品
function viewDetailGooods(ids){
    sessionStorage.setItem("detailId",ids);
    window.location.href="/phone/details.html"
};
function loadDetail(){
    var detailId=sessionStorage.getItem("detailId");
    $(".detailImg img").attr("src","");
    //查看详情
    /*alert(1)*/
    $.get("/TbGoodsApp/selectById",{
        gId:detailId
    },function(data){
        /*$(".bd ul li").remove();*/
        var urls=data.tbGoods.gPicture;
        var ww=urls.split(",");
        for(var i in ww){
            $(".bd ul").append("<li style='display table-cell;vertical-align:top;width: 200px;float: left'><img src='/image/getImg?path="+ww[i]+"' alt='' style='width:100%;height:270px'></li>");
        };
        TouchSlide({
            slideCell: "#ScrollBar",
            titCell: ".hd ul", //开启自动分页 autoPage:true ，此时设置 titCell 为导航元素包裹层
            mainCell: ".bd ul",
            effect: "left",
            autoPlay: false,//自动播放
            autoPage: true, //自动分页
            switchLoad: "_src" //切换加载，真实图片路径为"_src"
        });
        $(".detailData .gName").text(data.tbGoods.gName);
        $(".gPrice").text(data.tbGoods.gPrice);
        $(".detailData .gMonthSale span").text(data.tbGoods.gMonthSales);
        $(".detailData .gIn span").text(data.tbGoods.gInventory);
        $(".detailData .gFrie span").text(data.tbGoods.gFreight);
        /*详情图片*/
        var detailImg=(data.tbGoods.gDetails).split(",");
        for(var long in detailImg){
            $("#task-tab").append("<div style='margin:10px'><img src='/image/getImg?path="+detailImg[long]+"' style='width: 100%' alt=''' alt=''></div>")
        };
        /*评论列表*/
        console.log(data.comments.length);
        if(data.comments.length==0){
            $(".comments").append("<div style='line-height: 60vh;text-align: center'><img src='/images/nons.png'><h1 style='color:#ccc;text-align: center;'>暂无评论</h1></div>")
        }else{
            $(".comments").children(":gt(0)").remove();
            for(var comen in data.comments){
                var newtr=$(".comments .none").clone().removeClass("none");
                newtr.children().find(".user img").attr("src","/image/getImg?path="+data.comments[comen].tbUser.uHeadPortrait)
                newtr.children().find(".body .name").text(data.comments[comen].tbUser.uName);
                newtr.children().find(".time .green").text(dateUtil(data.comments[comen].tbPersonIndent.piCreateDate));
                newtr.children().find(".text span").text(data.comments[comen].tbPersonIndent.piEvaluateLanguage);
                var starCons=data.comments[comen].tbPersonIndent.piEvaluateGrade;
                for(var sar=0;sar<starCons;sar++){
                    newtr.children().find("#box #imgul li").eq(sar).addClass("active");
                };
                $(".comments").append(newtr);
            };
        }
    });
};
/*立即购买*/
function loadbuy(){
    var detailId=sessionStorage.getItem("detailId");
    $.get("/TbGoodsApp/selectById",{
        gId:detailId
    },function(data){
        $(".detailData .gName").text(data.tbGoods.gName);
        $(".detailData .gFrie span").text(data.tbGoods.gFreight);
    });
    $.get("/TbDeliveryAddressApp/selectAll",{
        pageSize:100,
        TokenID:TokenID
    },function(data){
        var addressList = data.pageInfo.list;
        console.log(addressList.length)
        if(addressList.length==0){
            $("#shopBuyModalBody").append("<div style='text-align: center;color:#ccc;font-size: 16px;padding-top:10px' onclick='returnload(2)'>暂无收货地址，去添加？</div>")
        }else{
            // console.log(addressList);
            $("#shopBuyModalBody > div").remove();
            $("#shopBuyModalBody > br").remove();
            for(var address in addressList){
                (addressList[address].daIsDefault) == 1 ? $("#addressId").val(addressList[address].daId) : "";
                $("#shopBuyModalBody").append("<div id='address"+addressList[address].daId+"'"+((addressList[address].daIsDefault) == 1 ? 'class="active4"' : "")+
                    " onClick='updateAddressType("+addressList[address].daId+")'>姓名:"+addressList[address].daName+
                    "  手机号:"+addressList[address].daPhone+
                    "  地址:"+addressList[address].daDetailAddress+
                    "  是否默认:"+((addressList[address].daIsDefault) == 1 ? "是" : "否")+
                    "  备注:"+addressList[address].daRemark+"</div><br>");

            };
        }

    });
};

function updateAddressType(daId){
    $('#addressId').val(daId);

    $("#shopBuyModalBody > div").removeClass("active4");
    $('#address'+daId).addClass("active4");

};
/*提交订单*/
function buy() {
    var piGId=sessionStorage.getItem("detailId");
    var piQuantity=$("input[name='shopNumber']").val();
    var addressId = $("#addressId").val();
    $.post("/TbGoodsApp/buy",{
        piGId:piGId,
        piQuantity:piQuantity,
        addressId:addressId,
        TokenID:TokenID
    },function(data){
        if(data.status==0){
            layer.open({
                content: data.message,
                skin: 'msg'
                ,time: 2
            });
        }else{
            layer.open({
                content: data.message,
                btn:"确定",
                yes:function(){
                    sessionStorage.removeItem("detailId");
                    returnload(0);
                }
            });
        }
    });
}