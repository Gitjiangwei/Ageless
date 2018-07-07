$(function(){
	var categoryThreeId = $(".category03").val();

	selectAllSort(categoryThreeId);
    selectAllSku(categoryThreeId);


	var i = 0;
	
	$(".hide111").change(function(){
		if(i>4){
			alert("No more than 5");
			return;
		}
		i++;
		var file =document.getElementById("pic"+i);
		var imgUrl =window.URL.createObjectURL(file.files[0]);
		$(".tupian"+i).attr("src",imgUrl);
		$(".tupian"+i).show();
	});

	$(".labelBtn2").click(function(){
		$(this).hide();
		$(this).next().show();
	});


	function selectAllSort(id){
        $.ajax({
            type:"post",
            url:"/sort/selects",
            data:{categoryThree:id},
            dataType:"json",
            success:function(data){
                var allsort="";
                data.map(function(item,index){
                    allsort +='<dl><dt><span>'+item.name+'</span></dt><dd><div class="fbox">'
                        +'<select class="textStyle xuanzhong" style="width:210px;">';
                    for(var i = 0 ; i< item.sortcons.length; i++ ){
                        allsort += '<option value="'+item.sortcons[i].sortconid+'">'+item.sortcons[i].sortconname+'</option>'
                    }
                    allsort +='</select></div></dd></dl>';
                });
                $(".shuxing").html(allsort);
            }
        });
    }
    function selectAllSku(id){
        $.ajax({
            type:"get",
            url:"/sku/cha",
            data:{id:id,nam:null},
            dataType:"json",
            success:function(data){
                var allsort="";
                data.map(function(item,index){

                    allsort +='<ul class="SKU_TYPE"><li class="sku_table_ss" is_required="1" propid="'+item.id+'" sku-type-name="'+item.propertyName+'"><em>*</em>'+item.propertyName+'：</li></ul><ul>';
                    for(var i = 0 ; i< item.list.length; i++ ){
                        allsort += '<li><label><input type="checkbox" class="sku_value" propvalid="'+item.list[i].id+'" value="'+item.list[i].optionName+'" />'+item.list[i].optionName+'</label></li>';
                    }
                    allsort +='</ul><div class="clear"></div>';
                });
                $(".gg").html("");
                $(".gg").html(allsort);
            }
        });
    }

    $(".getSetSkuVal").on("click",function(){

       var product = {};
        product.productName = $("#productName").val();
        product.maidian = $("#maidian").val();
        if( product.productName ==null ||  product.productName==""){
            showWebAlert("请输入完整信息！");
            return false;
        }
        if( product.maidian ==null ||  product.maidian==""){
            showWebAlert("请输入完整信息！");
            return false;
        }
        var propid = "";
        $(".sku_table_ss").map(function (index,item){
            propid += $(item).attr("propid")+",";//SKU值主键
        });
        if(propid ==null || propid==""){
            showWebAlert("请输入完整信息！");
            return false;
        }
        var nums = 0;
        var propvals = "";
        $(".sku_table_tr").map(function (index,item){
            var propvalids = $(item).attr("propvalids");//SKU值主键
            var price = $(item).find(".setting_sku_price").val();
            if(price ==null || price=="" ){
                alert("请输入完整信息！");
                return false;
            }else  if(isNaN(price)==true){
                alert("价格只能为数字！");
                return false;
            }

            var kucun = $(item).find(".setting_sku_stock").val();
            if(kucun ==null || kucun=="" ){
                alert("请输入完整信息！");
            }else  if(isNaN(kucun)==true){
                alert("库存只能为数字！");
            }
            var propval = propvalids+","+price +","+kucun;
            propvals += propval + "-";
            nums += parseInt(kucun);
        });
        product.kucun = nums;
        product.category01 = $(".category01").val();
        product.category02 = $(".category02").val();
        product.category03 = $(".category03").val();
        editor.sync();//将KindEditor的数据同步到textarea标签。
        product.descript = $("#editor_id").val();

        var shux = "";
        $(".xuanzhong").map(function (index,item) {
			shux += $(item).val() +",";
		});
        product.sortConId = shux;
        var shopImg1 = $("#pic1")[0].files[0];
        var shopImg2 = $("#pic2")[0].files[0];
        var shopImg3 = $("#pic3")[0].files[0];
        var shopImg4 = $("#pic4")[0].files[0];
        var shopImg5 = $("#pic5")[0].files[0];
        var formData = new FormData();
        formData.append("shopImg1",shopImg1);
        formData.append("shopImg2",shopImg2);
        formData.append("shopImg3",shopImg3);
        formData.append("shopImg4",shopImg4);
        formData.append("shopImg5",shopImg5);
        formData.append("propid",propid);
        formData.append("propvals",propvals);
        formData.append("shopStr",JSON.stringify(product));
        $.ajax({
            url:"/commodity/addproject",
            type:"post",
            data:formData,
            contentType:false,
            processData:false,
            cache:false,
            success:function(data){
                if(data == "1"){
                    alert("商品添加成功！");
                    window.location.href="/commodity/goxiajia";
                }else{
                    showWebAlert("商品添加失败！");
                }
            }
        });
    });

});