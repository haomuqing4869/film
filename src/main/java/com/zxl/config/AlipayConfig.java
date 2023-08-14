package com.zxl.config;
import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2022-01-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 *
 *

app_id：应用ID，即您的APPID，用于唯一标识您的支付宝账号。

merchant_private_key：商户私钥，采用PKCS8格式的RSA2私钥。用于对请求参数进行签名。

alipay_public_key：支付宝公钥，用于验证支付宝返回的数据是否合法。

notify_url：服务器异步通知页面路径，当支付成功后，支付宝服务器会主动向该地址发送异步通知。

return_url：页面跳转同步通知页面路径，当支付成功后，通过该地址将用户重定向到您的网站。

sign_type：签名方式，这里使用RSA2。

charset：字符编码格式，这里使用UTF-8。

gatewayUrl：支付宝网关，用于发送支付请求。

log_path：日志存放路径，这里设置为C盘根目录。

此外，代码中还提供了一个logResult方法，用于将日志写入文件。
 */
public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "20230123456789_";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "20230123456789_MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCGIOFLJEndF45OcaO/tqt4S43ApfsaDVnvK8c+HLmsUrtgM0TyPfDzkYTFCF9oFdaPZUt7fxmHMbwxGYRZ45kDOwI1sQGBZRR+cNUUwcrxE4B4z2yUC4HIKm4h1xOU0U2i8Z23/HFPU/j/MSEATMR/IO4PMCLYNeBpM+WiC8j0G7qeBV9hAJui90u2PKg2mPPE6vpE8/3GfFvFTX+e5mhzte5IS8SNpqBwLkWn4vT1W2H4CI+k/lKhZGgNimC+FvCwKXlXV6sFeUFahPTYJ/zpurljZMgRmtfDv2rcNgYWlmngYMLyELPXIb+sE3hTGEaaObdraxEPS/Y/fZfG7WTTAgMBAAECggEAXYguMx0SGQglJ1SdkMIMXq2pIu9b5DXtQhhwL0MOwzlKCvKVoKtLDD6srE2DYmzgG0zSz0K5hYpMJp0ZqylIeXU7vD87woS/PtDl9jyRjX1A+H4ExFQl43SbKiP2Nq+iCP+eMT/rsBrppuMWlUPzPoezGopBsi4X2KTk/BRlxLtSRO20WorqQZYLMlAZI2WCjx6EpqhAazW5cqCn/oZomE7EcN4sgTH9nKFUVzwjF5hm8H5N8WmsbiVV/HUZK4CNRQOrYyOYTN9nuBQG6FeRuyHWaafLr4kpc3pyZzian0PYFkNDisOoa2FyS4cA9F+FSBdB4o36lScxoqsKKKu7eQKBgQDHtOlbiAG6C/K/h+xurMgEn7BgohxhE5FibmsRT05VedBXktuqFaXQinGxP9LwHRqX+/d6DIqbViQQyquevV7w4mAQlU43cGID4eprO8Mf+WtOIceSEMZTz4DuuObuePRuuhamoAayAL0keZSC0xgdNrtsle5dqWq2iqhhVfhslwKBgQCr78I7BbTRTwvewKSfONAfRtUn7AzqsYFle4HiI+7FFN3cIEv1qIy5nFPfzo2J0sK+aBqdqo8CDHbIR+OEBHZSSN8lmeJx5Mf8J0ZpkUn1QF8BV/PFYAOL+kWiHPwTtk+XIFU/bPtXUW76BwDTDbDvJpQFa2vJ55Hs5fYBbGdFJQKBgQC0h8pcP/qvoJV0pv8InZDC/UiIUoOtDe9jN8X6A+MgSdoZEF0ayC748e4M+VFKVkTwF4qD/kpeWeSIeW3jNfVZdIq68v2eCC3SrKso/QFLKkHig47Rb/CZWv+GzgeUlCsC3Z4USp1C1IAnNPEXwpQN9KhBZNfyO3CIS5gjRYApSQKBgAi1GLoSfOjIvwol6XBi2S9sT+k4rCLKoIn6KkbAmRwEBYRbYl1rjszrnNfNxx8+vDwWW5q2g42QAgf8lAogi7l5FUv7MhuggXxEpO09vWgdPXJ8+Mx7I1LYduRR4XZCGl/F9GtE4qm2Zw9kgWcu31INOxvXJ9tOzfYYY1AJJGW9AoGBALZiwWLfJUTb2i6V5FPkYRuMW+VhuJIi4hysV7CeyB1j6aT6l8fNaihCGqxNZ3jerhcbhaomK3SyRHiJRIR+ZySAE0sOijHSM0F8FdRpsyeuDgUstKshfSy/0ZmgTGbzYAeWPGWUbyaC+GzasCvvNSmaAvGK/TDDquuyerVegHJo";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "20230123456789_MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjxHR6pi39rEpYs9ef0aD0ILljW12MNOFnTUd+uNNflfnnl9Zt1EMsoE3oIMquImL5dt3XaNPJJ4cYBdRe7eZ5rWQPjNY9CdNncxzDrbGK8sDp9cYoCD+o2YMsHxuPzWNj31xjy8ZPicEHLaS2DPUKJgudYnCsldLn1j4D+4LqIGcQH8/6+CSwDz7Dcq76dEAGRglOhjWpL84BwiCnngMwOU7QupTwMGSB8T0NoCVa45ALqXnJjWS/m3J7TReMuvicelw3pj1W/p1sX2697meAT4BDjfEGAr92AZRfDMZABsv3t8hZO+U4PT2BqMjq10vl4Uhcxfg7NZ5zPCWGRXwOQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/success";
///ssm_model_war_exploded
    // http://localhost:8080/userorder/findorder?page=1&pagesize=2

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
