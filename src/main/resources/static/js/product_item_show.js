$(function () {
    var id = $("#cunProductId").attr("name");
    var fist = $(".fist");
    var ary = new Array();
    for (var i = 0 ;i < fist.length ; i++){
        b = fist.eq(i).val();
        ary[i] = b;
    }
    ProductShowRight(ary,id);
})

function ProductShowRight(ary,id) {
    $.ajax({
        type: "post",
        url: "/commodity/productRight-y",
        data: {ary:ary,id:id},
        /* dataType:"html",*/
        success: function (data) {
            $("#right").empty();
            $("#right").append(data);
        }, error: function (data) {
            alert("no");
        }
    });
}

function sku(q) {
    $(q).siblings('li').children().removeClass('on');
    $(q).children().addClass('on');
    /*$(".clearfix li a").click(function() {
        $(this).parent().siblings('li').children().removeClass('on');  // 删除其他兄弟元素的样式
        $(this).addClass('on');                            // 添加当前元素的样式
    });*/
    var id = $("#right").attr("name");
    var a = $(".on");
    var ary = new Array();
    for (var i = 0 ;i < a.length ; i++){
        b = a.eq(i).attr("name");
        ary[i] = b;
    }
    ProductShowRight(ary,id);
}

function add(canshu) {
    var skuId = $("#skuId").attr("name");
    var id = $("#right").attr("name");
    var shuliang = $("#shuliang").val();
    if (canshu == 'ljgm') {
        window.location.href="/commodity/udai_shopcart_pay?id="+id+"&skuid="+skuId+"&shuliang=" + shuliang;
    }else if (canshu == 'gwc') {
        $.ajax({
            type: "post",
            url: "/shop/udai_shopcart.html",
            data: {skuId:skuId,id:id,shuliang:shuliang},
            dataType:"JSON",
            success: function (data) {
                if (data == 1){
                    alert("加入成功！");
                } else{
                    alert("加入失败！");
                }
            }, error: function (data) {
                alert("no");
            }
        });
    }
}

function pinglun(id) {
    $.ajax({
        type: "post",
        url: "/commodity/selectEvaluateByping",
        data:{id:id},
        /* dataType:"html",*/
        success: function (data) {
            $("#pinglun").empty();
            $("#pinglun").append(data);
        }, error: function (data) {
            alert("no");
        }
    });
}