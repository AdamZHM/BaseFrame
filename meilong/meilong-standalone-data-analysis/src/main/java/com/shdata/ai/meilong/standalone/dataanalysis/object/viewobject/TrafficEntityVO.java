package com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrafficEntityVO {
    /**
     * status : 1
     * info : OK
     * infocode : 10000
     * trafficinfo : {"description":"北三环路：双向畅通。","evaluation":{"expedite":"33.33%","congested":"0.00%","blocked":"0.00%","unknown":"66.67%","status":"2","description":"轻度拥堵"}}
     */

    private String status;
    private String info;
    private String infocode;
    private TrafficinfoBean trafficinfo;

    @Data
    public static class TrafficinfoBean {
        /**
         * description : 北三环路：双向畅通。
         * evaluation : {"expedite":"33.33%","congested":"0.00%","blocked":"0.00%","unknown":"66.67%","status":"2","description":"轻度拥堵"}
         */

        private String description;
        private EvaluationBean evaluation;
        @Data
        public static class EvaluationBean {
            /**
             * expedite : 33.33%
             * congested : 0.00%
             * blocked : 0.00%
             * unknown : 66.67%
             * status : 2
             * description : 轻度拥堵
             */
            @JsonAlias("expedite")
            private String roadExpedite;

            @JsonAlias("congested")
            private String roadCongested;

            @JsonAlias("blocked")
            private String roadBlocked;

            @JsonAlias("unknown")
            private String roadUnknown;


            private String status;
            private String description;
        }
    }
}
