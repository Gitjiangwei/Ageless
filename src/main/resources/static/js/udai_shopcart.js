new Vue({
    el:"#showshopping",
    data:{
        totalMoney:0,
        totalMum:0,
        productList:[],
        checkAllFlag: false,
        delFlag: false,
    },
    filters:{
        formatMoney: function (value) {
            return "￥" + value.toFixed(2)//前端不建议数据格式转换，会丢失精度
        }
    },
    mounted:function () {
        this.$nextTick(function () {
            this.cartView();
        })

    },
    methods:{
        cartView:function () {
            var _this=this;
            this.$http.get("/data/cart.json",{"id":123}).then(function (res) {
               // alert(res.data.result.productList.length);
                 _this.productList=res.data.result.productList;
                 _this.totalMoney=res.data.result.totalMoney;
            });
        },
        changeMoney:function (product,way) {
            //alert(product.productQuentity);
            if (way>0){
                product.productQuentity++;
            }else{
                product.productQuentity--;
                if(product.productQuentity<1){
                    alert("亲，不能再减啦！");
                    product.productQuentity=1;
                }
            }
            this.calcTotalPrice();
       },
        /*选种商品*/
        selectedProduct: function (item) {
            if (typeof item.checked == "undefined") {
                //Vue.set(item,"checked",true);//全局注册
                this.$set(item, "checked", true);//局部注册
            } else {
                item.checked = !item.checked;
            }
            this.calcTotalPrice();

        },
        checkAll: function (flag) {
            this.checkAllFlag = flag;
            var _this = this;
            this.productList.forEach(function (item, index) {
                if (typeof item.checked == "undefined") {
                    _this.$set(item, "checked", _this.checkAllFlag);//局部注册
                } else {
                    item.checked = _this.checkAllFlag;
                }
            });
            this.calcTotalPrice();

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
        delConfrim: function (item) {
            this.delFlag = true;
            this.product = item;
        },
        delProduct: function () {
            var index = this.productList.indexOf(this.curProduct);
            this.productList.splice(index, 1);
            /*从当前下标开始删除，删除一个*/
            this.delFlag = false;
            //实际中应该使用this.$http.post()传值id去调用控制器的接口并返回结果
        },


}

})
Vue.filter("money", function (value, type) {
    return "￥" + value.toFixed(2) + type;
})

































