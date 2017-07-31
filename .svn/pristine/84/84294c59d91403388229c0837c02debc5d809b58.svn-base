/**
 * Created by 婵 on 2017/1/12.
 */
$(function(){
    /*置顶*/
    $(window).scroll(function(){
        if($(window).scrollTop()>100){
            $("#gotop").fadeIn(400);
        }else{
            $("#gotop").fadeOut(400);
        }
    })
    $("#gotop").click(function(){
        $("body,html").animate({scrollTop:0},200);
        return false;

    })
    /*左侧*/
    $(".submenu li").off("click");
    $(".submenu li").on("click",function(){
        $(".submenu li").removeClass("active");
        $(".nav-list>li").removeClass("active");
        if(!$(this).hasClass("active")){
            $(this).addClass("active");
            $(this).parent().parent().addClass("active");
            $(this).parent().parent().addClass("open")

            var url=$(this).children().attr("url");
            $(".main-content").load(url);
        }
    });
    indes(".submenu li");


});
/*默认点击*/
function indes(quick,num){
    num= num || 0;
    $(quick).eq(num).trigger("click");
};

//登录
function loginData(){
    var username=$(".login-box input[name='username']").val();
    var password=$(".login-box input[name='password']").val();
    if(username==""){
        alert("请输入账号");
    }else if(password==""){
        alert("请输入密码");
    }else{
        $.post("/TbUser/ajaxLogin",{
            "username":username,
            "password":password
        },function(data){
            if(data.status==1){
                window.open('/userManagement.html',"_self");
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

    if(phone==""){
        alert("请输入手机号码");
    }else {
        $.post("/TbUser/obtainVerificationCode",{
            phone:phone,
            type:id
        },function(data){
            if(data.status==1){
                /*$(btns).text("已发送");
                 $(btns).css("disabled","disabled");*/
                time(btns);
            }else if(data.status==0){
                alert("发送失败");
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
    var account=$(".forgot-box input[name='account']").val();
    var pass=$(".forgot-box input[name='pass']").val();
    var verificationCode=$(".forgot-box input[name='verificationCode']").val();
    if(account==""){
        alert("请输入手机号码")
    }else if(pass==""){
        alert("请输入密码");
    }else if(verificationCode==""){
        alert("请输入验证码")
    }else{
        $.post("/TbUser/forgetPassByAccount",{
            account:account,
            pass:pass,
            verificationCode:verificationCode
        },function(data){
            alert(data.message);
            window.location.reload();
        })
    }
};
/*注册*/
function checkeregister(){
    var uPhone=$(".signup-box input[name='uPhone']").val();
    $.post("/TbUser/isRegister",{
        phone:uPhone
    },function(data){
        if(data.status==0){
            alert("用户已注册");
        }
    })
};
function registerUser(){
    var uPhone=$(".signup-box input[name='uPhone']").val();
    var uPassword=$(".signup-box input[name='uPassword']").val();
    var uReisterRecommenderAccount=$(".signup-box input[name='uReisterRecommenderAccount']").val();
    var verificationCode=$(".signup-box input[name='verificationCode']").val();
    if(uPhone==""){
        alert("请输入手机号码");
    }else if(uPassword==""){
        alert("请输入密码");
    }else if(verificationCode==""){
        alert("请输入验证码");
    }else {
        $.post("/TbUser/registerByPhone",{
            uPhone:uPhone,
            uPassword:uPassword,
            uReisterRecommenderAccount:uReisterRecommenderAccount,
            verificationCode:verificationCode
        },function(data){
            alert(data.message);
            window.location.reload();
        })
    }
};

/*获取TokenID*/
function GetQueryString(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)
        return  unescape(r[2]);
    return null;
};

/*顶部*/
function loadData(){
    $.get("/TbUser/selectMe",function(data){
        var type1;
        if(data.tbUser.uType==0){
            type1="普通用户";
            $(".checkMyLine").attr("url","management/noPermission.html");
        }else if(data.tbUser.uType==1){
            type1="银卡会员";
        }else if(data.tbUser.uType==2){
            type1="金卡会员";
        }else if(data.tbUser.uType==3){
            type1="铂金会员";
        }else if(data.tbUser.uType==4){
            type1="普通会员";
        }else if(data.tbUser.uType==5){
            type1="管理员";
            $(".admins").removeClass("none");
            $(".rechase").removeClass("none");
        }
        var uAuthentication;
        if(data.tbUser.uAuthentication==0){
            uAuthentication="未认证";
        }else if(data.tbUser.uAuthentication==1){
            uAuthentication="已认证";
            $(".userAuth").attr("url","management/hasOn.html");
        }
        $(".type").text(type1);
        $(".userName").text(data.tbUser.uName);
        $(".uAuthentication").text(uAuthentication);
        $(".nav-user-photo").attr("src","/image/getImg?path="+data.tbUser.uHeadPortrait)
        $(".nav-user-photo").attr("alt",data.tbUser.uName+"的头像")
    });
};
//时间
function dateUtil(value){
    var date = new Date(value);
    return date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日  "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
};
/*---------------------------------------*/
//查看个人信息
function loadPerInfo(){
    $.get("/TbUser/selectMe",function(data){
        if(data.tbUser.uHeadPortrait!=null){
            $("#headPortrait").attr("src","/image/getImg?path="+data.tbUser.uHeadPortrait);
        }
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
//修改个人信息
function modifyPerInfo(){
    var uName=$(":text[name='uName']").val();
    var uHeadPortrait=$(":text[name='uHeadPortrait']").val();
    var uPhone=$(":input[name='uPhone']").val();
    var uSex=$(":radio[name='uSex']:checked").val();
    var uProvince=$(":text[name='uProvince']").val();
    var uCity=$(":text[name='uCity']").val();
    var uAddress=$(":text[name='uAddress']").val();
    var uRemark=$("textarea[name='uRemark']").val();
    $.post("/TbUser/updateMe",{
        uName:uName,
        uHeadPortrait:uHeadPortrait,
        uPhone:uPhone,
        uSex:uSex,
        uProvince:uProvince,
        uCity:uCity,
        uAddress:uAddress,
        uRemark:uRemark
    },function(data){
        alert(data.message);
        window.location.reload();
    });

};
//修改密码
function modifyPwd(){
    var oldPasswd=$("input[name='oldPasswd']").val();
    var passwd=$("input[name='passwd']").val();
    var passwd2=$("input[name='passwd2']").val();
    if(passwd!=passwd2){
        alert("两次密码不一致，请重新输入")
    }else if(oldPasswd==""){
        alert("请输入旧密码");
    }else {
        $.post("/TbUser/updatePass",{
            oldPasswd:oldPasswd,
            passwd:passwd,
            passwd2:passwd2
        },function(data){
            alert(data.message);
            window.location.reload();
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
    $.get("/TbUser/selectMember",{
        number:num
    },function(data){
        if(data.tbUsers.length==0){
            $(".contents").children(":gt(0)").remove();
            $(".contents").append("<tr><td colspan='6'>暂无下线</td></tr>")
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
                var newtr=$("#member .none").clone().removeClass("none");
                newtr.children().eq(0).text(data.tbUsers[aus].uName);
                newtr.children().eq(1).text(data.tbUsers[aus].uPhone);
                newtr.children().eq(2).text(type1);
                newtr.children().eq(3).text(dateUtil(data.tbUsers[aus].uCreateDate));
                newtr.children().eq(4).text(data.tbUsers[aus].uReisterRecommender);
                newtr.children().eq(5).text(data.tbUsers[aus].uSumMoney);
                $("#member").append(newtr);
            };
        };

    });
};
//上一个下线
function lastType(){
    var number = $(".numberType").text()-1;
    if(number == 0){
        alert("已经到底了");
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
        alert("已经到底了");
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
        alert("请输入姓名");
    }else if(aIdentityCard==""){
        alert("请输入身份证账号");
    }else if(aIdentityCardPicture==""){
        alert("请上传身份证照片");
    }else{
        $.post("/TbAuthentication/insert",{
            aRealName:aRealName,
            aIdentityCard:aIdentityCard,
            aIdentityCardPicture:aIdentityCardPicture,
            aRemark:aRemark
        },function(data){
            alert(data.message);
            window.location.reload();
        });
    }
};
//
function clearMessage(){
    $(".message").css("display","none");
};
//查看个人消费  分页
function showUserComsum(pageNum,pageSize){
    $.get("/TbConsumption/selectAll",
        {
            pageNum : pageNum,
            pageSize : pageSize
        },function(data){

            $(".uSumMoney").text(data.sumMoney);
            $(".uUsableMoney").text(data.usableMoney)
            if(data.tbConsumptions.length==0){
                $(".consum").children(":gt(0)").remove();
                $(".consum").append("<tr><td colspan='4' style='text-align: center'>暂无消费记录!</td></tr>")
            }else{
                $(".consum").children(":gt(0)").remove();
                for(var tip in data.tbConsumptions){
                    var newtr=$(".consum .none").clone().removeClass("none");
                    newtr.children().eq(0).text(data.tbConsumptions[tip].cSource);
                    newtr.children().eq(1).text(data.tbConsumptions[tip].cMoney);
                    newtr.children().eq(2).text(dateUtil(data.tbConsumptions[tip].cCreateDate));
                    newtr.children().eq(3).text(data.tbConsumptions[tip].cRemark);
                    $(".consum").append(newtr);
                }
            }
            //分页
            console.log(data.pageInfo);
            var paging = $("#paging > .pagination");
            paging.empty();
            // alert(paging);
            if(data.pageInfo.hasPreviousPage){
                paging.append("<li class='prev' onClick='showUserComsum("+data.pageInfo.prePage+")'><a href='#'><i class='icon-double-angle-left'></i></a></li>");
            }else{
                paging.append("<li class='prev disabled'><a href='#'><i class='icon-double-angle-left'></i></a></li>");
            }
            var nums = data.pageInfo.navigatepageNums;
            var pageNum = data.pageInfo.pageNum;
            for(var num in nums){
                if(pageNum == (nums[num])){
                    paging.append("<li class='active'><a href='#'>"+nums[num]+"</a></li>");
                }else{
                    paging.append("<li  onClick='showUserComsum("+nums[num]+")'><a href='#'>"+nums[num]+"</a></li>");
                }
            }

            if(data.pageInfo.hasNextPage){
                paging.append("<li class='next' onClick='showUserComsum("+data.pageInfo.nextPage+")'><a href='#'><i class='icon-double-angle-right'></i></a></li>");
            }else{
                paging.append("<li class='next disabled'><a href='#'><i class='icon-double-angle-right'></i></a></li>");
            }

        })
};


/*---------购买商品----------------*/
//查找所有商品
function userViewGoods(){
    /*$(".goodsList li").remove();*/
    $.get("/TbGoods/selectAll",function(data){
        for(var k in data.tbGoodss){
            $(".goodsList").append("<li onclick='viewDetailGooods("+data.tbGoodss[k].gId+")'><div class='sImg'><img src='/image/getImg?path="+data.tbGoodss[k].gPicture+"' alt=''></div><div class='sPrice'>￥<span>"+data.tbGoodss[k].gPrice+"</span></div><div class='sTitle'><a href='#'> "+data.tbGoodss[k].gName+"</a></div></li>")
        }
    })
};
//查看详细商品
function viewDetailGooods(ids){
    $(".main-content").load("shopping/detaiShopping.html");
    $(".detailImg img").attr("src","");
    //查看详情
    /*alert(1)*/
    $.get("/TbGoods/selectById",{
        gId:ids
    },function(data){
        $(".big_Img img").attr("src","/image/getImg?path="+data.tbGoods.gPicture);
        $(".smallImg li").remove();
        $("#task-tab div").remove();
        var urls=data.tbGoods.gPicture;
        var ww=urls.split(",");
        for(var i in ww){
            $(".smallImg").append("<li><img onmouseover='hov(this)' src='/image/getImg?path="+ww[i]+"' alt=''></li>");
        };
        $(".detailData .gName").text(data.tbGoods.gName);
        $(".detailData .gPrice").text(data.tbGoods.gPrice);
        $(".detailData .gMonthSale p").text(data.tbGoods.gMonthSales);
        $(".detailData .gIn span").text(data.tbGoods.gInventory);
        $(".detailData .gFrie span").text(data.tbGoods.gFreight);
        /*详情图片*/
        var detailImg=(data.tbGoods.gDetails).split(",");
        for(var long in detailImg){
            $("#task-tab").append("<div style='margin:10px'><img src='/image/getImg?path="+detailImg[long]+"' alt='' style='width:100%'></div>")
        };
        /*评论列表*/
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
        }

        //feng
        $("#shopBuy").attr("onClick","shopBuy("+data.tbGoods.gId+")");

        $('#shopBuyModal').on('shown.bs.modal', function (e) {
            $.get("/TbDeliveryAddress/selectAll",{
                pageSize:100
            },function(data){
                var addressList = data.pageInfo.list;
                // console.log(addressList);
                $("#shopBuyModalBody > div").remove();
                $("#shopBuyModalBody > br").remove();
                for(var address in addressList){
                    console.log(addressList[address]);

                    (addressList[address].daIsDefault) == 1 ? $("#addressId").val(addressList[address].daId) : "";
                    $("#shopBuyModalBody").append("<div id='address"+addressList[address].daId+"'"+((addressList[address].daIsDefault) == 1 ? 'class="active3"' : "")+
                        " onClick='updateAddressType("+addressList[address].daId+")'>姓名:"+addressList[address].daName+
                        "  手机号:"+addressList[address].daPhone+
                        "  地址:"+addressList[address].daDetailAddress+
                        "  是否默认:"+((addressList[address].daIsDefault) == 1 ? "是" : "否")+
                        "  备注:"+addressList[address].daRemark+"</div><br>");

                }
            })
        })

    });
};
/**
 * feng
 * 点击购买按钮
 */
function shopBuy(gId){
    var shopNumber = $("#shopNumber").val();
    console.log(gId+" ; "+shopNumber);

    $('#shopBuyModal').modal({
        keyboard: true
    });

    $("#shopAffirm").attr("onClick","buy("+gId+","+shopNumber+")");

}
function buy(gId,shopNumber){
    var addressId = $("#addressId").val();
    // alert(gId + " ; " + shopNumber + " ; " + addressId);
    $.get("/TbGoods/buy",{
        piGId:gId,
        piQuantity:shopNumber,
        daId:addressId
    },function(data){
        alert(data.message);
        $("#shopBuyModal").modal("hide");
        indes(".shops li",1);
    })
}
function updateAddressType(daId){
    $('#addressId').val(daId);

    $("#shopBuyModalBody > div").removeClass();
    $('#address'+daId).addClass("active3");

}
//评论提交
function commentSubmit(){
    var piEvaluateLanguage = $("#piEvaluateLanguage").val();
    var piEvaluateGrade = $('#piEvaluateGrade').val();
    var pinId = $("#pinId").val();
    // alert(piEvaluateLanguage + " ; " + piEvaluateGrade + " ; " + pinId);
    $.get("/TbGoods/comment",{
        piId:pinId,
        piEvaluateLanguage:piEvaluateLanguage,
        piEvaluateGrade:piEvaluateGrade
    },function(data){
        alert(data.message);
        $("#purChaseComment").modal('hide');
        indes(".shops li",1);
    })

};
//星级评论
function updateGrade(Grade){
    $('#imgul > li').removeClass("active");
    for(var i=0;i<Grade;i++){
        $("#imgul li").eq(i).addClass("active");
    };
    $('#piEvaluateGrade').val(Grade);
};

function hov(sd) {
    $(".smallImg li").removeClass("active");
    var url=$(sd).attr("src");
    $(".big_Img img").attr("src",url);
    $(sd).parent().addClass("active");
};
//查看收货地址
function viewAdress() {
    $(".viewAdr").children(":gt(0)").remove();
    $.get("/TbDeliveryAddress/selectAll",{
        pageSize:100
    },function(data){
        for(var len in data.pageInfo.list){
            var def;
            if(data.pageInfo.list[len].daIsDefault=="0"){
                def="否";
            }else if(data.pageInfo.list[len].daIsDefault=="1"){
                def="是";
            }
            var newtr=$(".viewAdr .none").clone().removeClass("none");
            newtr.children().eq(0).text(data.pageInfo.list[len].daName);
            newtr.children().eq(1).text(data.pageInfo.list[len].daPhone);
            newtr.children().eq(2).text(data.pageInfo.list[len].daDetailAddress);
            newtr.children().eq(3).text(def);
            newtr.children().eq(4).text(data.pageInfo.list[len].daRemark);
            newtr.children().eq(5).append("<button class='btn-danger' onclick='hasDefualt("+data.pageInfo.list[len].daId+")'>默认</button><button class='btn-danger' onclick='deleteAdress("+data.pageInfo.list[len].daId+")'>删除</button>");
            $(".viewAdr").append(newtr);
        }
    })
};
//添加收货地址
function addAdress(){
    var daName=$("#addAdre input[name='daName']").val();
    var daPhone=$("#addAdre input[name='daPhone']").val();
    var daDetailAddress=$("#addAdre input[name='daDetailAddress']").val();
    var daIsDefault=$("#addAdre :radio[name='daIsDefault']:checked").val();
    var daRemark=$("#addAdre textarea[name='daRemark']").val();
    if(daName==""){
        alert("请输入收件人");
    }else if(daPhone==""){
        alert("请输入手机号码");
    }else if(daDetailAddress==""){
        alert("请输入详细地址");
    }else{
        $.post("/TbDeliveryAddress/insert",{
            daName:daName,
            daPhone:daPhone,
            daDetailAddress:daDetailAddress,
            daIsDefault:daIsDefault,
            daRemark:daRemark
        },function(data) {
            alert(data.message);
            indes(".shops li",2);
        });
    }
};
//设置默认
function hasDefualt(id){
    $.post("/TbDeliveryAddress/settingDefault",{
        daId:id
    },function(data){
        alert(data.message);
        indes(".shops li",2);
    });
};
//删除收货地址
function deleteAdress(id) {
    $.post("/TbDeliveryAddress/deleteById",{
        daId:id
    },function(data){
        alert(data.message);
        indes(".shops li",2);
    })
};
/*购买记录*/
function viewPurCharse() {
    $(".lisr img").attr("src","");
    $(".pusrchar").children(":gt(0)").remove();
    $.get("/TbGoods/selectAllByUserId",function(data1){
        for(var good in data1.tbGoodss){
            var ids='"'+(data1.tbGoodss[good].tbPersonIndent.piId).toString()+'"';
            var newtr=$(".pusrchar>.none").clone().removeClass("none");
            var as;
            if(data1.tbGoodss[good].tbPersonIndent.piStatus=="1"){
                as="等待发货";
            }else if(data1.tbGoodss[good].tbPersonIndent.piStatus=="2"){
                as="已发货";
                newtr.children().find("#btn_trems").append("<button class='btn btn-info' onclick='confirmReceipt("+ids+")'>确认收货</button>");
            }else if(data1.tbGoodss[good].tbPersonIndent.piStatus=="3"){
                as="已到货，等待评论";
                var piId = '"' + data1.tbGoodss[good].tbPersonIndent.piId + '"';
                newtr.children().find("#btn_trems").append("<button class='btn btn-info' type='button' data-toggle='modal' data-target='#purChaseComment' data-backdrop='true' onclick='productReviews("+piId+")'>评论</button>");
            }else if(data1.tbGoodss[good].tbPersonIndent.piStatus=="4"){
                newtr.children().find(".wuliu").addClass("none");
                as="完成";
                newtr.children().find(".frim").append("<div>评论：<span>"+data1.tbGoodss[good].tbPersonIndent.piEvaluateLanguage+"</span></div>");
            };
            newtr.children().find(".creatData").text(dateUtil(data1.tbGoodss[good].tbPersonIndent.piCreateDate));
            newtr.children().find(".purChaseNum span").text(data1.tbGoodss[good].tbPersonIndent.piId);
            newtr.children().find(".imgs").attr("src","/image/getImg?path="+data1.tbGoodss[good].tbGoods.gPicture);
            newtr.children().find(".gName").text(data1.tbGoodss[good].tbGoods.gName);
            newtr.children().find(".gPrice span").text(data1.tbGoodss[good].tbGoods.gPrice);
            newtr.children().find(".count span").text(data1.tbGoodss[good].tbPersonIndent.piQuantity);
            newtr.children().find(".status span").text(as);
            newtr.children().find(".pen span").text(data1.tbGoodss[good].uName);
            newtr.children().find(".penTel span").text(data1.tbGoodss[good].tbPersonIndent.daPhone);
            newtr.children().find(".penAd span").text(data1.tbGoodss[good].tbPersonIndent.daDetailAddress);
            var tracking = '"' + data1.tbGoodss[good].tbPersonIndent.piTrackingNumber + '"';
            var code = '"' + data1.tbGoodss[good].tbPersonIndent.piCarrierCode + '"';
            newtr.children().find("#btn_trems").append("<button class='btn btn-info' type='button' data-toggle='modal' data-target='#purChaseW' data-backdrop='true' onclick='productW("+tracking+","+code+")'>查看物流</button>");
            newtr.children().find("#btn_trems").append("<button class='btn btn-info' onclick='deletePuy("+ids+")'>删除</button>");

            $(".pusrchar").append(newtr);
        };

        $('#purChaseComment').on('shown.bs.modal', function (e) {

            $('#imgul > li:lt(1)').addClass("active");
            $('#piEvaluateGrade').val(1);

        });
    });
};
/*查看物流*/
function productW(num1,num2){
    $("#wuliu1 div").remove();
    if(num1==null ||num1=="" || num1=="null"){
        $(".wln #wuliu1>span").append("<div style='text-align: center'>暂无物流信息</div>")
    }else{
        $.post("/TbPersonIndent/selectExpress",{
            tracking_number:num1,
            carrier_code:num2,
        },function(datas){
            var wuliu=$.parseJSON(datas.expressCompany).data.items[0].origin_info.trackinfo;
            if(wuliu==null||wuliu==""){
                $(".wln #wuliu1>span").append("<div style='text-align: center'>暂无物流信息</div>")
            }else{
                for(var tip in wuliu){
                    $(".wln #wuliu1>span").append("<div><span style='color:darkred'>"+wuliu[tip].Date+":</span><span style='margin-left: 5px'>"+wuliu[tip].StatusDescription+"</span></div>")
                };
            };
        });
    }
}
/*删除购买记录*/
function deletePuy(id){
    $.post("/TbGoods/deleteByUserId",{
        piid:id,
    },function(data){
        alert(data.message);
        indes(".shops li",1);
    });

}
//确认收货
function confirmReceipt(id){
    $.post("/TbPersonIndent/updateStatusById",{
        'piId':id.toString(),
        'piStatus':'3'
    },function (data) {
        alert(data.message);
        indes(".shops li",1);
    })
};
//评论
function productReviews(id) {
    $("#pinId").val(id);
}
