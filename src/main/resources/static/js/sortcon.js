
function chuan(q) {
    $(q).siblings('li').removeClass('active');  // 删除其他兄弟元素的样式
    $(q).addClass('active');// 添加当前元素的样式

    var ary = shuzu();

    alert(ary);
    $.ajax({
        type: "post",
        url: "/qweqwe",
        data: {list:ary},
        /* dataType:"html",*/
        success: function (data) {
            $(".xuan").empty();
            $(".xuan").append(data);
        }, error: function () {
            alert("no");
        }
    });
}


function paixu(tiaojian) {
    var ary = shuzu();

    $.ajax({
        type: "post",
        url: "/qweqwe",
        data: {list:ary,tiaojian:tiaojian},
        /* dataType:"html",*/
        success: function (data) {
            $(".xuan").empty();
            $(".xuan").append(data);
        }, error: function () {
            alert("no");
        }
    });
}


function shuzu() {
    var ary = new Array();
    for (var i = 0; i < $(".active").length; i++) {

       // ary[i]=$(".active").eq(i).attr("name");
    }
    return ary;
}

