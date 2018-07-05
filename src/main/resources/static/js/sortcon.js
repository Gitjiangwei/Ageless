function chuan(q) {
    $(q).siblings('li').removeClass('active');  // 删除其他兄弟元素的样式
    $(q).addClass('active');// 添加当前元素的样式

    var ary = shuzu();

    $.ajax({
        type: "post",
        url: "/sort/qweqwe",
        data: {list: ary},
        /* dataType:"html",*/
        success: function (data) {
            $(".xuan").empty();
            $(".xuan").append(data);
        }, error: function () {
            alert("no");
        }
    });
}


function paixu(fu) {

    $(fu).siblings('a').removeClass('qu');  // 删除其他兄弟元素的样式
    $(fu).addClass('qu');// 添加当前元素的样式

    var tiaojian = $(".qu").attr("name");
    var ary = shuzu();

    $.ajax({
        type: "post",
        url: "/sort/qweqwe",
        data: {list: ary, tiaojian: tiaojian},
        /* dataType:"html",*/
        success: function (data) {
            $(".xuan").empty();
            $(".xuan").append(data);
        }, error: function () {
            alert("no");
        }
    });
}

//获得4级被选列表的数组
function shuzu() {
    var ary = new Array();
    for (var i = 0; i < $(".active").length; i++) {
        ary[i] = $(".active").eq(i).attr("name");
    }
    return ary;
}


function show(pageindex) {

    var tiaojian = $(".qu").attr("name");
    var ary = shuzu();
    $.ajax({
        type: 'post',
        url: '/sort/qweqwe',
        data: {list: ary, pageIndex: pageindex, tiaojian: tiaojian},
        success: function (data) {
            $(".xuan").empty();
            $(".xuan").append(data);
        }, error: function () {
            alert("no");
        }
    })

}


function show1(pageCount) {
    var ye = document.getElementById("ye").value;
    if (ye > pageCount) {
        alert("输入错误");
        return;
    }
    if (ye < 1) {
        alert("输入错误");
        return;
    }
    var tiaojian = $(".qu").attr("name");
    var ary = shuzu();
    $.ajax({
        type: 'post',
        url: '/sort/qweqwe',
        data: {list: ary, pageIndex: ye, tiaojian: tiaojian},
        success: function (data) {
            $(".xuan").empty();
            $(".xuan").append(data);
        }, error: function () {
            alert("no");
        }
    })
}