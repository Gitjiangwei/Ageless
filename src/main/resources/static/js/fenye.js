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

function shu() {
    var tiaojian = $(".qu").attr("name");
    var a=$("#page").val();
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