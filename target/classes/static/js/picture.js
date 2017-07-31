/**
 * Created by 婵 on 2017/1/17.
 */
//上传图片
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
//上传多张图片
function uploadImg(t1,t2,t3){
    var formData = new FormData($(t1)[0]);
    /*  formData.append("TokenID",TokenID);*/
    $.ajax({
        url: '/image/upload',
        type: 'POST',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function(data){
            $(t2).append("<li style='position: relative'><div style='visibility: hidden;width: 20px;position: absolute;top:0;left:0'>"+data.filePath+"</div><img style='width: 80px;height: 60px' src='/image/getImg?path="+data.filePath+"'><i style='position: absolute;top:0;right:0' class='icon-remove' onclick='removeImg(this)'></i></li>")
            if($(t3).val()==""){
                $(t3).val(data.filePath);
            }else{
                $(t3).val($(t3).val()+","+data.filePath);
            }
        },
        error: function(){
            $("#spanMessage").html("与服务器通信发生错误");
        }
    });
};
/*删除图片*/
function removeImg(isd){
    var ipusImg=$(isd).parent().parent().parent().prev().children().children().eq(1);
    var src=$(isd).parent().children().eq(0).text();
    $(isd).parent().remove();
    var str=ipusImg.val().split(",");
    var arr=[];
    for(var i in str){
        if(src!=str[i]){
            arr.push(str[i])
        }
    };
    var imgSrc=arr.toString();
    ipusImg.val(imgSrc);
};
//查看多张图片
function viewMore(url) {
    $(".modal-body .showImg").attr("src","");
    $(".modal-body>div h1").remove();
    var urls=$(url).prev().text();
    $(".modal-body .showImg").attr("src","/image/getImg?path="+urls+"&number=1");
    $(".visibilyImg").text(urls);
    /*if(urls==""){
        $(".modal-body>div").remove();
        $(".modal-body>div").append("<h1 style='text-align: center'>暂无图片</h1>")
    }else{
        $(".modal-body .showImg").attr("src","/image/getImg?path="+urls+"&number=1");
        $(".visibilyImg").text(urls);
    }*/
};
/*查看上一张图片*/
function prevImg() {
    var url=$(".modal-body .visibilyImg").text().split(",");
    var imgCount = url.length;
    var src2 = $(".modal-body .showImg").attr("src");
    var number= src2.substring(src2.indexOf("number")+7,src2.length);
    if( number > 1){
        //执行
        $(".modal-body .showImg").attr("src","/image/getImg?path="+url+"&number="+(number-1));
    }else{
        alert("没有图片了");
    }
};
/*查看下一张图片*/
function nextImg() {
    var url=$(".modal-body .visibilyImg").text().split(",");
    var imgCount = url.length;
    var src2 = $(".modal-body .showImg").attr("src");
    var number= src2.substring(src2.indexOf("number")+7,src2.length);
    if( number < imgCount){
        //执行
        var ads=parseInt(number)+1;
        $(".modal-body .showImg").attr("src","/image/getImg?path="+url+"&number="+ads);
    }else{
        alert("没有图片了");
    }
};