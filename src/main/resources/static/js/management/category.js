$(function(){

	getCategoryListOne();

	$(".categoryOne").on("click",".one",function(){
		$(this).css("background-color","red");
		$(this).siblings().css("background-color","white");
		var context = $(this).html();
		var id = $(this).attr("data-id");
		$(".msg1").html(context);
		$(".msg1").attr("oneId",id);
		getCategoryListTwo(id);
	});

	$(".categoryTwo").on("click",".two",function(){
		$(this).css("background-color","red");
		$(this).siblings().css("background-color","white");
		var context = "-->"+$(this).html();
		var id = $(this).attr("data-id");
		$(".msg2").html(context);
		$(".msg2").attr("twoId",id);
		getCategoryListThree(id);
	});

	$(".categoryThree").on("click",".three",function(){
		$(this).css("background-color","red");
		$(this).siblings().css("background-color","white");
		var context = "=>"+$(this).html();
		var id = $(this).attr("data-id");
		$(".msg3").html(context);
        $(".msg3").attr("threeId",id);
	});

	$(".tiao").click(function(){
		var context = $(".msg").text();
		if(context==null || context ==""){
			return false;
		}
		var oneId=$(".msg1").attr("oneId");
		var twoId=$(".msg2").attr("twoId");
		var threeId=$(".msg3").attr("threeId");
		location.href="/commodity/goaddproject?context="+context+"&oneId="
			+oneId+"&twoId="+twoId+"&threeId="+threeId;
	});

	function getCategoryListOne(){

        $.ajax({
            type:"post",
            url:"/CateOne/getcategory1list",
            data:{name:null},
            dataType:"json",
            success:function(data){
                var oneCategory="";
                data.map(function(item,index){
                    oneCategory +='<li class="one" data-id="'+item.id
                        +'">'+item.categoryName+'</li>';
                });
                $(".categoryOne").html(oneCategory);
            }
        });

	}

	function getCategoryListTwo(id){

        $.ajax({
            type:"post",
            url:"/CateTwo/Twolist",
            data:{id:id},
            dataType:"json",
            success:function(data){
                var twoCategory="";
                data.map(function(item,index){
                    twoCategory +='<li class="two" data-id="'+item.id
                        +'">'+item.categoryName+'</li>';
                });
                $(".categoryTwo").html(twoCategory);
            }
        });

	}

	function getCategoryListThree(id){

        $.ajax({
            type:"post",
            url:"/CateThree/Threelist",
            data:{id:id},
            dataType:"json",
            success:function(data){
                var threeCategory="";
                data.map(function(item,index){
                    threeCategory +='<li class="three" data-id="'+item.id
                        +'">'+item.categoryName+'</li>';
                });
                $(".categoryThree").html(threeCategory);
            }
        });
	}
});