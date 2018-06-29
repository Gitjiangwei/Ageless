new Vue({
    el:"#orders",
    data:{
        totalMoney:0,
        totalMum:0,
        productList:[],

    },
    filters:{
       /* formatMoney: function (value) {
            return "￥" + value.toFixed(2)//前端不建议数据格式转换，会丢失精度
        }*/
    },
    mounted:function () {
        this.$nextTick(function () {
            this.cartView();
        })

    },
    methods:{
        cartView:function () {
            var _this=this;
            this.$http.get("/Order/all").then(function (json) {
               /* alert(json);*/
                _this.productList=json.data;

            });
        },


        /*计算购物车中全部商品的总消费*/
        calcTotalPrice: function () {
            var _this = this;
            this.totalMoney = 0;
            this.totalMum=0;
            this.productList.forEach(function (item, index) {
                if (item.checked) {
                    _this.totalMoney += item.productPrice * item.productQuentity;
                    _this.totalMum+=item.productQuentity;
                }
            });

        },


    }

})
Vue.filter("money", function (value, type) {
    return "￥" + value.toFixed(2) + type;
})

































