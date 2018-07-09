
$(function(){

hh(null,0,null);
$(document).on("click", "#cx", function () {
    var numbers = $("#number").val();
    var ids = $("#id").val();
    var createDates = $("#createDate").val();
    hh(numbers,ids,createDates);

});

    $(document).on("click", "#open", function () {
        var obj = $(this);
        var text = obj.attr("num");
        $.ajax({
            type: "GET",
            url: "/Order/xqs",
            data: {nid:text},
            dataType: "json",
            success: function (data) {
                $("#xqing").html("");
                    $("#xqing").append(
                    "<dl> <dt><span>订单编号</span></dt> <dd> <div class='number'>"
                    +data[0].number+ "</div></dd></dl><dl><dt><span>交易流水号</span></dt><dd> <div class='atch'>"
                    +data[0].atch+"</div> </dd> </dl> <dl> <dt><span>所属用户</span></dt> <dd> <div class='user'>"
                    +data[0].name+" </div> </dd> </dl> <dl> <dt><span>收货地址</span></dt> <dd> <div class='addressid'>"
                    +data[0].province+data[0].city+data[0].area+data[0].street +"</div> </dd> </dl> <dl> <dt><span>订单金额</span></dt><dd><div class='price'>￥"
                    +data[0].orderPrice+" </div></dd></dl> <dl> <dt><span>订单状态</span></dt><dd> <div class='orderStatus'>"
                    +data[0].status+"</div></dd> </dl> <dl> <dt><span>创建时间</span></dt> <dd> <div class='createDate'>"
                    +data[0].createDate+"</div></dd> </dl>")
                }

        })
    })
    $(document).on("click", ".del", function () {
    var obj = $(this);
    var text = obj.attr("num");
    deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', text);

})
})
function result(bz, choose) {
    if(choose) {

        $.ajax({
            type: "GET",
            url: "/Order/sc",
            data: {nid:bz},
            dataType: "json",
            success: function (data) {
                if(data>0) {
                    $("#del" + bz).parent().parent().remove();
                    showWebAlert('删除成功！');
                }
            }, error: function () {
                alert("加载失败");
            }
        })

    }
}
$("#dall").click(function () {
    var text = $("input[type='checkbox']:checked").map(function (index, elem) {
        return $(elem).val();
    }).get().join();

    if (text == "") {
        alert("no checked");
        return;
    }
    var shifou = confirm("确定要删除吗？");
    if (shifou == false) {
        return;
    }
    $.ajax({
        type: "get",
        url: "/Order/dall",
        data: {nid: text},
        dataType: "json",
        success: function (data) {
            $("#del" +text[0]).parent().parent().remove();
            showWebAlert('删除成功！');
            var numbers = $("#number").val();
            var ids = $("#id").val();
            var createDates = $("#createDate").val();
            hh(numbers,ids,createDates);
        }, error: function () {
            alert("加载失败");
        }
    });
})
function hh(numbers,ids,createDates) {
    $.ajax({
        type: "GET",
        url: "/Order/xq",
        data: {numbers: numbers, id: ids, create: createDates},
        dataType: "json",
        beforeSend:function(XMLRequest){
            $("#tableuserlist").html("");
            $("#tableuserlist").append(
                "<tr><td colspan='6'><img src=\"/images/backstage/loading.gif\" /></td></tr>");
        },
        success: function (data) {
            $("#tableuserlist").html("");
            for (var i = 0; i < data.length; i++) {
                $("#tableuserlist").append(
                    "<tr><td><input type='checkbox' value=" + data[i].number+"></td><td>"+ data[i].number + "</td><td>" + data[i].name + "</td><td>"
                    + data[i].status + "</td><td>"
                    + data[i].orderPrice + "</td><td>"
                    + "<a href='javascript:;' id='open' class='button' num=" + data[i].number + ">详情</a> <a href='javascript:;' id='del"+ data[i].number+"'  class='button del' num=" + data[i].number + ">删除</a>"
                    + " </td></tr>");
            }
        }
    })
}