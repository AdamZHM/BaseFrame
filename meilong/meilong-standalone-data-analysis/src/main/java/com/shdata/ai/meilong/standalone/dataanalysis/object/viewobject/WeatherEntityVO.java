package com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class WeatherEntityVO {


    /**
     * lives : [{"province":"上海","city":"徐汇区","adcode":"310104","weather":"阴","temperature":"12","winddirection":"东北","windpower":"≤3","humidity":"91","reporttime":"2021-03-16 13:25:09"}]
     * count : 1
     * infocode : 10000
     * status : 1
     * info : OK
     */

    private String count;
    private String infocode;
    private String status;
    private String info;
    private List<LivesBean> lives;

    @Data
    public static class LivesBean {
        /**
         * province : 上海
         * city : 徐汇区
         * adcode : 310104
         * weather : 阴
         * temperature : 12
         * winddirection : 东北
         * windpower : ≤3
         * humidity : 91
         * reporttime : 2021-03-16 13:25:09
         */

        private String province;
        private String city;
        private String adcode;
        private String weather;
        private String temperature;

        @JsonAlias("winddirection")
        private String windDirection;

        @JsonAlias("windpower")
        private String windPower;
        private String humidity;
        private String reporttime;
    }
}
