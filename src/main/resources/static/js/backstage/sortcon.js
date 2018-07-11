var path = $("#path").val();
var customPropId = -1;//自定义属性类型ID
var customPropValId = -1;//自定义属性值id

$("#categoryLevel1").change(function(){

    var categoryLevel1 = $("#categoryLevel1").val();

    if(categoryLevel1 != '' && categoryLevel1 != null){



        $.ajax({
            type:"GET",//请求类型
            url:"/CateTwo/Twolist",//请求的url
            data:{id:categoryLevel1},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）

                $("#categoryLevel2").html("");
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){



                    options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#categoryLevel2").html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载二级分类失败！");
            }
        });
    }else{
        $("#categoryLevel2").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel2").html(options);
    }
    $("#categoryLevel3").html("");
    var options = "<option value=\"\">--请选择--</option>";
    $("#categoryLevel3").html(options);
});

$("#categoryLevel2").change(function(){
    var categoryLevel2 = $("#categoryLevel2").val();
    if(categoryLevel2 != '' && categoryLevel2 != null){
        $.ajax({
            type:"GET",//请求类型
            url:"/CateThree/Threelist",//请求的url
            data:{id:categoryLevel2},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                $("#categoryLevel3").html("");
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    //alert(data[i].id);
                    //alert(data[i].categoryName);
                    options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#categoryLevel3").html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载三级分类失败！");
            }
        });
    }else{
        $("#categoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel3").html(options);
    }
});

function  nav(num) {
    deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', num,'点确定后将删除属性及其对应的属性选项');
}
function result(bz, choose) {

    var falg=false;
    if(choose) {
        $.ajax({
            type: "GET",
            url: "/sort/del",
            data: {id: bz},
            dataType: "json",
            success: function (data) {
                if (data ==true||data==success) {
                    showWebAlert("删除成功！");

                     falg=true;
                } else if(data==false){
                    showWebAlert("删除失败！请刷新页面");
                } else{
                    showWebAlert("服务器异常！");
                }
              if(falg){
                    window.location.href="/sort/sortcon";
                }

            },
            error:function (data) {
                showWebAlert("服务器异常！");
            }
        });
    }

}




var zhi=0;
var fag=true;
$('#dianji').click(function () {
  zhi =$("#categoryLevel3").val();
   if(zhi>0){
       $("#yc").css("display","block");
   }else{
       showWebAlert("三级分类不能为空！");
   }

    });

    //克隆SKU模板生成自定义sku
    $(document).on("click" , ".cloneSku" , function(){
        var cloneSource = $("#skuCloneModel");//要克隆的sku模板

        var cloneNode = cloneSource.clone(true);//克隆出来的节点
        cloneNode.css("display","block");//显示元素
        //移除id
        cloneNode.removeAttr("id");
        customPropId -- ;
        //设置自定义属性类型主键
        $(cloneNode).find(".cusSkuTypeInput").parent().attr("propid",customPropId);
        $(cloneNode).find(".cusSkuTypeInput").parent().attr("pd",customPropId);
        //设置SKU类型主键 propid
        $(cloneNode).find(".cusSkuValInput").prev().attr("propid",customPropId);
        $(cloneNode).find(".cusSkuValInput").prev().attr("pd",customPropId);
        customPropValId -- ;
        //设置自定义属性类型值主键
        $(cloneNode).find(".cusSkuValInput").prev().attr("propvalid",customPropValId);
        $(this).before(cloneNode);//添加到该按钮的前面
    });

    //添加自定义sku值
    $(document).on("click",".cloneSkuVal",function(){
        //要克隆的SKU值模板
        var cloneSource = $("#onlySkuValCloneModel");
        //克隆出来的节点
        var cloneNode = cloneSource.clone(true);
        //移除id
        cloneNode.removeAttr("id");
        //获取并设置SKU类型主键
        var propid = $(this).parents("").prev().find("li").attr("propid");
        $(cloneNode).find(".cusSkuValInput").prev().attr("propid",propid);
        $(cloneNode).find(".cusSkuValInput").prev().attr("pd",propid);
        customPropValId -- ;
        //设置自定义属性类型值主键
        $(cloneNode).find(".cusSkuValInput").prev().attr("propvalid",customPropValId);
        //显示元素
        cloneNode.css("display","block");
        //添加到该按钮的前面
        $(this).before(cloneNode);
    });

    //SKU类型改变
    $(document).on("change", ".cusSkuTypeInput", function(){
        //判断当前的SKU类型是否已经存在
        var isHaveThisSkuType = false;
        var customSkuTypeName = $(this).val();
        if(customSkuTypeName){
            $("ul[class*='SKU_TYPE']").find("li").each(function(){
                var currSkuTypeName = $(this).attr("sku-type-name");//当前SKU类型名称
                if(currSkuTypeName == customSkuTypeName){//该SKU类型已经存在
                    isHaveThisSkuType = true;
                }
            });
        }
        if(isHaveThisSkuType){
            showWebAlert("该SKU类型已经存在!");
            $(this).val("");
            fag=false;
        }
        //赋值类型属性
        $(this).parent().attr("sku-type-name",$(this).val());
        if(!$(this).val() || isHaveThisSkuType){
            $(this).parent().parent().next().find("input[type='checkbox'][class*='sku_value']").each(function(){
                //取消选中
                $(this).attr("checked",false);
                //移除class
                $(this).removeClass("sku_value");
            });
        }
        //触发change事件,重绘表格
        $(".model_sku_val").trigger("change");
    });

    //SKU值改变
    $(document).on("change", ".cusSkuValInput", function(){
        var isHaveSkuVal = false;//是否已经存在当前的SKU值
        var thisSkuVal = $(this).val();
        //判断SKU值是否已经重复了
        $(".model_sku_val,.sku_value").each(function(){
            var customSkuVal = $(this).val();//当前SKU值
            if(thisSkuVal == customSkuVal){
                isHaveSkuVal = true;
                return;
            }
        });

        if(isHaveSkuVal){
            showWebAlert("该SKU类型已经存在!");
            $(this).val("");
            fag=false;
        }
        $("input[type*='checkbox'][class*='']")
        var cusSkuVal = $(this).val();
        if(!cusSkuVal || isHaveSkuVal){
            //移除class
            $(this).prev().removeClass("sku_value");
            if($(this).prev().is(":checked")){
                //移除选中
                $(this).prev().attr("checked",false);
            }
        }
        //赋值类型属性
        $(this).prev().val(cusSkuVal);
        //触发change事件
        $(".model_sku_val").trigger("change");
    });

    //未设置sku值和属性的sku选择框改变事件
    $(document).on("change",".model_sku_val",function(){
        //SKU类型
        var skuTypeVal = $(this).parent().parent().prev().find("li").attr("sku-type-name");
        //是否设置了sku类型及sku值
        if(skuTypeVal && $(this).val()){
            //添加class
            $(this).addClass("sku_value");
        }
        //触发change事件,重绘表格
        $("input[type='checkbox']").first().trigger("change");
    });

    //删除自定义sku类型模块
    $(document).on("click",".delCusSkuType",function(){
        $(this).parent().parent().parent().remove();
        //触发change事件,重绘表格
        $("input[type='checkbox']").first().trigger("change");
    });

    //删除自定义sku值
    $(document).on("click",".delCusSkuVal",function(){
        $(this).parent().remove();
        //触发change事件,重绘表格
        $("input[type='checkbox']").first().trigger("change");
    });
$(document).on("click",".quxiao",function(){
    $("#yc").css("display","none");
});
    //提交
    $(document).on("click",".bc",function(){

        var Sort = new Array(); //sku类型对象

        var propid = $("li[pd]");

        //获取属性信息
        propid.each(function(){
            var skuTypeObj = {};//sku类型对象

             skuTypeObj.categorythreeId=zhi;
            var typeName = $(this).find("input[class*='cusSkuTypeInput']").val();

            skuTypeObj.name = typeName;
           // alert("属性名称：" + typeName );
            //获取每个属性对应的属性选项的信息

            skuValueArr = [];//存放SKU值得数组
            var skuVals =  $(this).parent().parent().find("input[type='text'][class*='cusSkuValInput']");
            skuVals.each(function(){
                var skuValObj = {};//SKU值对象
              //alert("属性名称：" +typeName+ ": " + $(this).val());
                skuValObj.sortconname=$(this).val();
                skuValueArr.push(skuValObj);
            });

            skuTypeObj.sortcons= skuValueArr;

            Sort.push(skuTypeObj);

        });



if(fag){
    $ .ajax({
        type: "POST",
        url: "/sort/add",
        data: JSON.stringify(Sort),
        contentType:"application/json;charset=utf-8",
        dataType: "json",
        success: function (data) {
            if(data==true){
                showWebAlert("添加成功")
            }else{
                showWebAlert("添加失败")
            }
            window.location.href="/sort/sortcon";
        },
        error:function (data) {
            showWebAlert("服务器异常！");
        }
    });
}

} );

$(document).on("click",".ti",function () {
    var id = $(this).parent().parent().attr("cid");

    var name = $(this).prev().val();

    if(name !=null && name!=""){
        $.ajax({
            type: "GET",
            url: "/sort/xiu",
            data: {id: id,name:name},
            dataType: "json",
            success: function (data) {
                if(data=="1"){
                    alert("修改成功");
                    $(".ming").val(name);
                    $(".t").html("");
                }else{
                    alert("修改失败");
                }
            }
        });

    }else{
        alert("对不起修改内容为空！");
    }
});
$(document).on("click",".tij",function () {
    var sid = $(this).parent().parent().attr("sid");

    var sortconname = $(this).prev().val();

    if(sortconname !=null && sortconname!=""){
        $.ajax({
            type: "GET",
            url: "/sort/update",
            data: {sortconid: sid,sortconname:sortconname},
            dataType: "json",
            success: function (data) {
                if(data=="1"){
                    alert("修改成功");
                    $("#op"+sid).val(sortconname);
                    $(".t").html("");
                }else{
                    alert("修改失败");
                }
            }
        });

    }else{
        alert("对不起修改内容为空！");
    }
});

$(document).on("click",".qx",function (){

    $(".t").html("");



});

$(".fanhui").click(function () {
    window.location.href="/sort/sortcon";
});