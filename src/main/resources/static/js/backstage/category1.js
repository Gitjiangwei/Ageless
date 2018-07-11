var categoryUrl = "/CateOne/getcategory1list";
var addCategory = "/CateOne/Oneinsert";
$(function () {
    getCategoryListOne(null);

    $("#cha").click(function () {
        var leiming = $(".leiming").val();
        getCategoryListOne(leiming);
    });


    $(document).on("click",".ti",function () {
        var id = $(this).parent().attr("cid");
        var name = $(this).prev().val();
        if(name !=null && name!=""){
            $.ajax({
                type: "GET",
                url: "/CateOne/xiugai",
                data: {id: id,categoryName:name},
                dataType: "json",
                success: function (data) {
                    if(data==1){
                        showWebAlert("修改成功");
                        getCategoryListOne(null);
                    }else{
                        showWebAlert("修改失败");
                    }
                }
            });

        }else{
            showWebAlert("请填写修改内容！");
        }
    });



    $(".save").click(function () {

    var tempArr = $(".tianjia");
    var categoryNameList =new Array();
    tempArr.map(function (index,item) {
        tempObj = $(item).val();
        categoryNameList.push(tempObj);
    });
    $.ajax({
        type:"post",
        url:addCategory,
        data:{categoryNameList:categoryNameList.toString()},
        dataType:"json",
        success:function(data){
            if(data.result=="success"){
                showWebAlert("添加成功！");
                getCategoryListOne(null);
                $("#xianshi").hide();
                $(".sortcon :first").val("");
                $(".sortcon :first").siblings().remove();
            }else{
                showWebAlert("添加失败！");
            }
        }
    });
});
})

function nav(id) {
    deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', id,'删除后该类型下面的信息将全部删除');
}
function getCategoryListOne(param){

    $.ajax({
        type:"post",
        url:categoryUrl,
        data:{name:param},
        dataType:"json",
        success:function(data){
            var oneCategory="<tr><th>&nbsp;</th><th>编号</th><th>一级分类名</th><th>操作</th></tr>";
            data.map(function(item,index){
                oneCategory +='<tr><th>&nbsp;</th><th>'+item.id+'</th><th>'+item.categoryName+'</th>'
                    +'<th><button class="button" style="height: 28px;width: 65px;" onclick="nav('+item.id+')">删除</button>&nbsp;&nbsp; <button style="height: 28px;width: 65px;" class="button aaa">修改</button><span cid='+item.id+'></span></th></tr>';
            });
            $(".categoryOne").html("");
            $(".categoryOne").html(oneCategory);
        }
    });
}

function result(bz, choose) {
    if(choose) {
        $.ajax({
            type: "GET",
            url: "/CateOne/shanchu",
            data: {id: bz},
            dataType: "json",
            success: function (data) {
                if (data == "1") {
                    showWebAlert("删除一二三级分类成功！");
                } else if(data=="2"){
                    showWebAlert("删除一二级分类成功！");
                }else if(data=="3"){
                    showWebAlert("删除该分类成功！");
                }else{
                    showWebAlert("删除失败！");
                }
                getCategoryListOne(null);
            }
        });
    }

}




