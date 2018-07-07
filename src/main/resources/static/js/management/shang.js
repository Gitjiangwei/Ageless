$(function () {
    nav();
});
$(document).on("click","#button1",function () {
    nav();
});
function nav(){

    $.ajax({
        type:"get",
        url:"/shang/shanglist",
        data:{},
        dataType:"json",
        success:function(data){
            var oneCategory;
            var twoCategory;
            twoCategory +='<tr>\n<th><input type="checkbox"></th><th>宝贝名称</th><th>宝贝图片</th><th>库存</th><th>总销量</th><th>发布时间</th></tr>';
            data.map(function(item,index){
                oneCategory +='<tr><td><input type="checkbox" name="box" id="id" value='+item.id+'>已上架</td> <td>'+item.productName+'</td><td><img src="'+item.productPic.picPath+'" width="100" height="100"></td> <td>'+item.kucun+'</td> <td>'+item.xiaoliang+'</td> <td>'+item.update+'</td></tr>';
            });
            $("#yifen").html("");
            $("#yifen").html(twoCategory+oneCategory);
        },
    });
};
$(document).on("click","#button3",function () {
    nav2();
});
function nav2(){

    $.ajax({
        type:"get",
        url:"/shang/shanglist2",
        data:{},
        dataType:"json",
        success:function(data){
            var oneCategory;
            var twoCategory;
            twoCategory +='<tr>\n<th><input type="checkbox"></th><th>宝贝名称</th><th>宝贝图片</th><th>库存</th><th>总销量</th><th>下架时间</th><th>操作</th></tr>';
            data.map(function(item,index){
                oneCategory +='<tr><td><input type="checkbox" name="box" id="id" value='+item.id+'>已下架</td> <td>'+item.productName+'</td><td><img src="'+item.productPic.picPath+' "  height="100" width="100"></td><td>'+item.kucun+'</td> <td>'+item.xiaoliang+'</td> <td>'+item.downdate+'</td><td><a href="/shang/modify?id='+item.id+'">修改商品</a></td></tr>';
            });
            $("#yifen").html("");
            $("#yifen").html(twoCategory+oneCategory);
        },
    });
};
$(document).on("click","#button2",function () {
    nav();
    var s =[];
    var w=	$("input:checkbox[name='box']:checked");

    if(w.length==0){
        alert("请选择要下架的商品");
    }else {
        $("input:checkbox[name='box']:checked").each(function () {
            s.push($(this).val());
        });
        $.ajax({
            type: "get",
            url: "/shang/shangupdate",
            data: {"s": s},
            traditional:true,
            dataType: "json",
            success: function (data) {
                if (data > 0) {
                    alert("商品已下架");
                } else {
                    alert("商品下架失败");
                }
                nav();
            },
        });
    }
});
$(document).on("click","#button4",function () {
    nav();
    var s =[];
    var w=	$("input:checkbox[name='box']:checked");

    if(w.length==0){
        alert("请选择要上架的商品");
    }else {
        $("input:checkbox[name='box']:checked").each(function () {
            s.push($(this).val());
        });
        $.ajax({
            type: "get",
            url: "/shang/shangupdate1",
            data: {"s": s},
            traditional:true,
            dataType: "json",
            success: function (data) {
                if (data > 0) {
                    alert("商品已上架");
                } else {
                    alert("商品上架失败");
                }
                nav2();
            },
        });
    }
});


