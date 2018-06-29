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

function add() {
    var skuId = $("#skuId").attr("name");
    alert(skuId);
    var id = $("#right").attr("name");
    alert(id);
    var shuliang = $("#shuliang").val();
    alert(shuliang);

}