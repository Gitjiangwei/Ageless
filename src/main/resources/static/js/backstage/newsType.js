//窗体加载事件
$(function () {

    selectNews();

//删除点击事件
    $(document).on("click",".del",function() {
        var id= $(this).attr("val");
        deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', id, 'del','删除后该类型下面的信息将全部删除');
        //deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', id,'删除后该类型下面的信息将全部删除');
    });

    //新增方法
    $(document).on("click","#save",function() {
        insertNews();
        //showWebAlert('新增成功！');
    });
})

//查询所有方法
function selectNews() {
    $.ajax({
        type:"GET",
        url:"/er/selectNews",
        dataType:"json",
        success:function (data) {
            $("#selcetNews").html("");
            for (var i=0;i<data.length;i++){
                $("#selcetNews").append("<tr><td>"+data[i].nId+"</td><td>"+data[i].typeName+"</td><td>" +
                    "<a href='javascript:;' id='del"+data[i].nId+"' val="+data[i].nId+" class='button del'>删除</a>" +
                    "</td></tr>");
            }
        }
    });
}


function result(bz, choose,choo) {
    if (choose) {
        $.ajax({
            type:"GET",
            url:"/er/deletNews",
            data:{nId:bz},
            dataType:"json",
            success:function (data) {
                if(data>0) {
                    $("#del" + bz).parent().parent().remove();
                    showWebAlert('删除成功！');
                }
            }
        });
    }
}
//新增方法
function insertNews() {
    var form =$("#ll").serialize();
    $.ajax({
        type:"GET",
        url:"/er/insertNews",
        data:form,
        dataType:"json",
        success:function (data) {

            showWebAlert('新增成功！');
            selectNews();
        }
    });
}