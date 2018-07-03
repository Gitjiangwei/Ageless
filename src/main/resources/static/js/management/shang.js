$ (function (){
    $.ajax({
        type:"get",
        url:"/shang/shanglist",
        data:{},
        dataType:"json",
        success:function(data){
            var oneCategory;
            var twoCategory;
            twoCategory +='<tr>\n<th><input type="checkbox"></th><th>宝贝名称</th><th>价格</th><th>库存</th><th>总销量</th><th>发布时间</th><th>操作</th></tr>';
            data.map(function(item,index){
                oneCategory +='<tr><td><input type="checkbox"><br />已 <br />推<br />荐</td> <td>'+item.productName+'</td> <td>'+item.price+'</td> <td>'+item.kucun+'</td> <td>'+item.xiaoliang+'</td> <td>'+item.update+'</td> <td>操作</td> </tr>';
            });
            $("#yifen").html("");
            $("#yifen").html(twoCategory+oneCategory);
        },
    });


} )

