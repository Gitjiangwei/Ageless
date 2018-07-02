new Vue({
    el:"#xunhuan",
    data:{
        totalMoney:0,
        shopList:[],
    },
    filters:{
    },
    mounted:function () {
        this.$nextTick(function () {
            this.cartView();
        })
    },
    methods:{
        cartView:function () {
            this.shopList=[]
            var _this=this;
            this.$http.get("/shop/getTotalMoney").then(function (json) {
                _this.totalMoney=json.data;
                alert(_this.totalMoney);
               /* _this.productList=json.data;
                for (var i =0;i<json.data.length;i++){
                    _this.picPathList=json.data[i].picPath;
                    /!* alert(json.data[i].picPath);*!/
                }*/
            });
            this.$http.get("/shop/getList").then(function (json) {
                _this.shopList=json.data;

                /*for (var int i;i<json.data.length;i++){

                }*/
                alert(json.data.length);
            });
        },
    }
})



Vue.filter("money",function (value,type) {
return "￥"+value.toFixed(2)+type;
})



