package cn.demo.http.model;

public class Goods {
    private String goodsId;
    private String goodsName;
    private String goodsImage;
    //    private Bitmap goodsPicBitmap;
    private String categoryId;
    private String goodsSpec;
    private int goodsPrice;
    private String goodsMsg;
    private int goodsStock;

    public Goods (String goodsName, String goodsImage) {
        this.goodsName = goodsName;
        this.goodsImage = goodsImage;

    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getgoodsImage() {
        return goodsImage;
    }

    public void setgoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsMsg() {
        return goodsMsg;
    }

    public void setGoodsMsg(String goodsMsg) {
        this.goodsMsg = goodsMsg;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }
}
