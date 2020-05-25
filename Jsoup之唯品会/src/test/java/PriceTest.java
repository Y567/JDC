import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceTest {

    @Test
    public void getPrice() throws IOException {
        String url = "https://detail.vip.com/detail-1710613331-6918372411111616979.html";
        //1.0获得价格的方法
        //1.1获取brandId和6918哪个，这个可以获取到价格
        String[] urlPart = url.split("-");
        String brandId = urlPart[1];
        String vip = urlPart[2].substring(0,urlPart[2].length()-5);
        String priceUrl = "https://mapi.vip.com/vips-mobile/rest/shopping/pc/product/detail/v5?callback=detailInfoCB&productId="+vip+"&warehouse=VIP_BJ&client_type=pc&fdc_area_id=101101101&brandid="+brandId+"&api_key=70f71280d5d547b2a7bb370a529aeea1&app_name=shop_pc&app_version=4&device=1&mars_cid=1589991394840_255563790e7fef836c6b3fa268502642&source_app=pc&mobile_platform=1&functions=brand_store_info%2CnewBrandLogo%2Csku_price&highlightBgImgVer=1";
        Connection.Response execute = Jsoup.connect(priceUrl).header("Accept", "*/*").header("Referer", url).header("Accept-Encoding", "gzip, deflate, br").ignoreContentType(true).execute();
        String body = execute.body();
        StringBuffer price = new StringBuffer();
        int i = body.indexOf("specialPrice");
        char[] target = body.substring(i, i + 20).toCharArray();
        for (char c : target) {
            if (('0' <= c && c <= '9') || c == '.') {
                price.append(c);
            }
        }
        System.out.println(price);
    }
}
