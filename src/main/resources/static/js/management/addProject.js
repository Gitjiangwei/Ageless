$(function(){
	var categoryThreeId = $(".category03").val();

	selectAllSort(categoryThreeId);

	var i = 0;
	
	$(".hide111").change(function(){
		if(i>2){
			alert("No more than 3");
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
                        +'<select class="textStyle" style="width:210px;">';
                    for(var i = 0 ; i< item.sortcons.length; i++ ){
						allsort += '<option value="'+item.sortcons[i].sortconid+'">'+item.sortcons[i].sortconname+'</option>'
					}
                    allsort +='</select></div></dd></dl>';
                });
                $(".shuxing").html(allsort);
            }
        });
	}

    $(".getSetSkuVal").on("click",function(){
        $(".sku_table_tr").map(function (index,item){
            var propids = $(item).attr("propids");//SKU类型主键
            var propvalids = $(item).attr("propvalids");//SKU值主键
			var price = $(item).
			alert(propvalids);
        });
    });

});