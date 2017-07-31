/**
 * Created by 婵 on 2017/1/18.
 */
//管理员添加商品
function addShopping(){
    var gName=$(".sel_tab input[name='gName']").val();
    var gPrice=$(".sel_tab input[name='gPrice']").val();
    var gFreight=$(".sel_tab input[name='gFreight']").val();
    var gInventory=$(".sel_tab input[name='gInventory']").val();
    var gRemark=$(".sel_tab textarea[name='gRemark']").val();
    var gPicture=$(".sel_tab input[name='gPicture']").val();
    var gDetails=$(".sel_tab input[name='gDetails']").val();
    if(gName==""){
        alert("请输入商品名称");
    }else if(gPrice==""){
        alert("请输入商品价格");
    }else if(gInventory==""){
        alert("请输入库存");
    }else if(gPrice<0){
        alert("请输入不小于0的数字");
    }else {
        $.post("/TbGoods/insert",{
            gName:gName,
            gPrice:gPrice,
            gFreight:gFreight,
            gRemark:gRemark,
            gPicture:gPicture,
            gDetails:gDetails,
            gInventory:gInventory
        },function(data){
            alert(data.message);
            indes(".shops li",3);
        })
    }
};
//管理员查看商品
function viewMerCharge() {
    $("#viewTask").children(":gt(0)").remove();
    $.get("/TbGoods/selectAll",function(data){
        for(var tip in data.tbGoodss){
            var newTr=$("#viewTask .none").clone().removeClass("none");
            newTr.children().eq(0).text(data.tbGoodss[tip].gName);
            newTr.children().eq(1).text(data.tbGoodss[tip].gPrice);
            newTr.children().eq(2).text(data.tbGoodss[tip].gFreight);
            newTr.children().eq(3).text(data.tbGoodss[tip].gQuantity);
            newTr.children().eq(4).text(data.tbGoodss[tip].gMonthSales);
            newTr.children().eq(5).text(data.tbGoodss[tip].gInventory);
            newTr.children().eq(6).append("<div style='visibility: hidden;width:5px;height:5px;overflow: hidden'>"+data.tbGoodss[tip].gPicture+"</div><button class='btn btn-danger bn' data-toggle='modal' data-target='#showPic' onclick='viewMore(this)'>查看图片</button>")
            newTr.children().eq(7).append("<div style='visibility: hidden;width:5px;height:5px;overflow: hidden'>"+data.tbGoodss[tip].gDetails+"</div><button class='btn btn-danger bn' data-toggle='modal' data-target='#showPic' onclick='viewMore(this)'>查看详情图片</button>");
            newTr.children().eq(8).text(dateUtil(data.tbGoodss[tip].gCreateDate));
            newTr.children().eq(9).text(dateUtil(data.tbGoodss[tip].gUpdateDate));
            newTr.children().eq(10).append("<button class='btn btn-xs btn-info modPlate' type='button' data-toggle='modal' data-target='#modifyGoodsData' data-backdrop='true' onclick='modifyGoods("+data.tbGoodss[tip].gId+")'><i class='icon-edit bigger-120'></i></button><button class='btn btn-xs btn-danger delGoods' type='submit' onclick='deletes("+data.tbGoodss[tip].gId+")'><i class='icon-trash bigger-120'></i></button>")
            $(".viewTask").append(newTr);
        }

    })
};
/*管理员修改商品*/
function modifyGoods(id){
    $("input").val("");
    $(".pic3 li").remove();
    $(".pic4 li").remove();
    $.post("/TbGoods/selectById",{
        gId:id
    },function(data){
        console.log(data)
        $(".modifyGoo .gId").text(data.tbGoods.gId);
        $(".modifyGoo input[name='gName']").val(data.tbGoods.gName);
        $(".modifyGoo input[name='gPicture']").val(data.tbGoods.gPicture);
        $(".modifyGoo input[name='gPrice']").val(data.tbGoods.gPrice);
        $(".modifyGoo input[name='gFreight']").val(data.tbGoods.gFreight);
        $(".modifyGoo input[name='gInventory']").val(data.tbGoods.gInventory);
        $(".modifyGoo input[name='gDetails']").val(data.tbGoods.gDetails);
        $(".modifyGoo textarea[name='gRemark']").val(data.tbGoods.gRemark);
        var url=$(".modifyGoo input[name='gPicture']").val()
        if(url==""){

        }else{
            var spli=url.split(",");
            for(var tips in spli){
                $(".pic3").append("<li style='position: relative'><div style='visibility: hidden;width: 20px;position: absolute;top:0;left:0'>"+spli[tips]+"</div><img style='width: 80px;height: 60px' src='/image/getImg?path="+spli[tips]+"'><i style='position: absolute;top:0;right:0' class='icon-remove' onclick='removeImg(this)'></i></li>")
            };
        }
        var conste=$(".modifyGoo input[name='gDetails']").val()
        if(conste==""){

        }else{
            var spli2=conste.split(",");
            for(var tip in spli2){
                $(".pic4").append("<li style='position: relative'><div style='visibility: hidden;width: 20px;position: absolute;top:0;left:0'>"+spli2[tip]+"</div><img style='width: 80px;height: 60px' src='/image/getImg?path="+spli2[tip]+"'><i style='position: absolute;top:0;right:0' class='icon-remove' onclick='removeImg(this)'></i></li>")
            };
        }

    })
};
/*提交修改后的商品*/
function addMOdGoods(){
    var gId=$(".modifyGoo .gId").text();
    var gName=$(".modifyGoo input[name='gName']").val();
    var gPicture=$(".modifyGoo input[name='gPicture']").val();
    var gPrice=$(".modifyGoo input[name='gPrice']").val();
    var gFreight=$(".modifyGoo input[name='gFreight']").val();
    var gInventory=$(".modifyGoo input[name='gInventory']").val();
    var gDetails=$(".modifyGoo input[name='gDetails']").val();
    var gRemark=$(".modifyGoo input[name='gRemark']").val();
    $.post("/TbGoods/updateById",{
        gId:gId,
        gName:gName,
        gPicture:gPicture,
        gPrice:gPrice,
        gFreight:gFreight,
        gInventory:gInventory,
        gDetails:gDetails,
        gRemark:gRemark
    },function(data){
        alert(data.message);
        $('#modifyGoodsData').modal('hide');
        indes(".shops li",3);
    })
};
/*管理员删除商品*/
function deletes(id){
    $.get("/TbGoods/deleteById",{
        "piId":id
    },function(data){
        alert(data.message);
        indes(".shops li",3);
    });
};
/*管理员查看订单状态*/
function viewOrderStatus(){
    $("#orders").children(":gt(0)").remove();
    $.get("/TbPersonIndent/selectAll",function(data){
        for(var k in data.tbPersonIndents){
            var newtr=$("#orders .none").clone().removeClass("none");
            var as;
            var conid='"'+(data.tbPersonIndents[k].tbPersonIndent.piId).toString()+'"';
            if(data.tbPersonIndents[k].tbPersonIndent.piStatus=="1"){
                var newtr=$("#orders .none").clone().removeClass("none");
                as="等待发货";
                $(".status span").css("color","red");

                newtr.children().find(".btns").append("<button class='btn btn-info' onclick='modifyOrderStatus("+conid+")'>发货</button>");
            }else if(data.tbPersonIndents[k].tbPersonIndent.piStatus=="2"){
                as="已发货";
            }else if(data.tbPersonIndents[k].tbPersonIndent.piStatus=="3"){
                as="已到货，等待评论"
            }else if(data.tbPersonIndents[k].tbPersonIndent.piStatus=="4"){
                as="完成"
            };
            if(data.tbPersonIndents[k].tbPersonIndent.piStatus=="2" && data.tbPersonIndents[k].tbPersonIndent.piCarrierCode ==null || data.tbPersonIndents[k].tbPersonIndent.piCarrierCode ==""){
                newtr.children().find(".btns").append("<button data-toggle='modal' data-target='#logisticsData' class='btn btn-info' onclick='addW("+conid+")'>添加物流信息</button>");
            }

            var apens;
            if(data.tbPersonIndents[k].tbPersonIndent.piEvaluateLanguage==null){
                apens="暂无评论"
            }else{
                apens=data.tbPersonIndents[k].tbPersonIndent.piEvaluateLanguage;
            }
            newtr.children().find(".creatData").text(dateUtil(data.tbPersonIndents[k].tbPersonIndent.piCreateDate));
            newtr.children().find(".piId").text(data.tbPersonIndents[k].tbPersonIndent.piId);
            newtr.children().find(".ims").attr("src","/image/getImg?path="+data.tbPersonIndents[k].tbGoods.gPicture);
            newtr.children().find(".gName").text(data.tbPersonIndents[k].tbGoods.gName);
            newtr.children().find(".gPrice span").text(data.tbPersonIndents[k].tbGoods.gPrice);
            newtr.children().find(".count span").text(data.tbPersonIndents[k].tbPersonIndent.piQuantity);
            newtr.children().find(".status span").text(as);
            newtr.children().find(".nam span").text(data.tbPersonIndents[k].uName);
            newtr.children().find(".daPhone span").text(data.tbPersonIndents[k].tbPersonIndent.daPhone);
            newtr.children().find(".adr span").text(data.tbPersonIndents[k].tbPersonIndent.daDetailAddress);
            newtr.children().find(".languange span").text(apens);
            var ids='"'+(data.tbPersonIndents[k].tbPersonIndent.piId).toString()+'"';
            newtr.children().find(".btns").append("<button class='btn btn-info' onclick='AdeletePuy("+ids+")'>删除</button>");
            $("#orders").append(newtr);

        }

    })
};
/*删除购买记录*/
function AdeletePuy(id){
    $.post("/TbGoods/deleteByUserId",{
        piid:id,
    },function(data){
        alert(data.message);
        indes(".shops li",4);
    });

}
/*管理员修改订单状态*/
function modifyOrderStatus(piId){
    // alert(piId);
    $.post("/TbPersonIndent/updateStatusById",{
        'piId':piId.toString(),
        'piStatus':'2'
    },function (data) {
        alert(data.message);
        indes(".shops li",4);
    });

};
//查找物流公司
function loadlog(){
    $.get("/TbPersonIndent/selectAllExpressCompany",function(data){
        for(var tip in data.expressCompany){
            for(var item in data.expressCompany[tip]){
                $("select[name='code']").append("<option value='"+item+"'>"+data.expressCompany[tip][item]+"</option>")
            }

        }
    })
};
/*添加物流信息*/
function addW(id) {
    $("#logisticsData .piId").text(id);
};
function addLog() {
    var piId= $("#logisticsData .piId").text();
    var tracking= $("input[name='tracking']").val();
    var code= $("select[name='code']").val();
    $.post("/TbPersonIndent/insertExpressCompany",{
        tracking_number:tracking,
        carrier_code:code,
        piId:piId
    },function(data){
        alert(data.message);
        $('#logisticsData').modal('hide');
        indes(".shops li",4);
    });
};