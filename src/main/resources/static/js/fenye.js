function sun(a) {
    $(a).siblings('a').removeClass('qu');  // 删除其他兄弟元素的样式
    $(a).addClass('qu');// 添加当前元素的样式
    var tiaojian = $(".qu").attr("name");
    $.ajax({
        type:"post",
        url:"/probyxiao.html",
        data:"product="+tiaojian,
        dataType:"html",
        success:function (data){
            $(".mv").empty();
            $(".mvs").empty();
            $(".mv").append(data);
        },error:function(){

        }
    })
}
function index(a) {
    var tiaojian = $(".qu").attr("name");
    $.ajax({
        type:"post",
        url:"/probyxiao.html",
        data:{product:tiaojian,pageindex:a},
        dataType:"html",
        success:function (data){
            $(".mv").empty();
            $(".mvs").empty();
            $(".mv").append(data);
        },error:function(){

        }
    })
}

function shu(b) {
    var tiaojian = $(".qu").attr("name");
    var a = $("#page").val();
    if (a > b) {
        alert("超出最大页数");
    } else if (a <= 0) {
        alert("超出最小页数");
    } else {
        $.ajax({
            type: "post",
            url: "/probyxiao.html",
            data: {product: tiaojian, pageindex: a},
            dataType: "html",
            success: function (data) {
                $(".mv").empty();
                $(".mvs").empty();
                $(".mv").append(data);
            }, error: function () {

            }
        })
    }
}

function upda(a) {
    $(a).siblings('a').removeClass('qu');  // 删除其他兄弟元素的样式
    $(a).addClass('qu');// 添加当前元素的样式
    var tiaojian = $(".qu").attr("name");
    $.ajax({
        type:"post",
        url:"/probyupdate.html",
        data:"up="+tiaojian,
        dataType:"html",
        success:function (data){
            $(".mv").empty();
            $(".mvs").empty();
            $(".mv").append(data);
        },error:function(){

        }
    })
}
function indexs(a) {
    var tiaojian = $(".qu").attr("name");
    $.ajax({
        type:"post",
        url:"/probyupdate.html",
        data:{up:tiaojian,pageindex:a},
        dataType:"html",
        success:function (data){
            $(".mv").empty();
            $(".mvs").empty();
            $(".mv").append(data);
        },error:function(){

        }
    })
}

function shus(b) {
    var tiaojian = $(".qu").attr("name");
    var a=$("#page").val();
    if(a>b){
        alert("超出最大页数");
    }else if(a<=0){
        alert("超出最小页数");
    }else{
        $.ajax({
            type:"post",
            url:"/probyupdate.html",
            data:{up:tiaojian,pageindex:a},
            dataType:"html",
            success:function (data){
                $(".mv").empty();
                $(".mvs").empty();
                $(".mv").append(data);
            },error:function(){

            }
        })
    }

}