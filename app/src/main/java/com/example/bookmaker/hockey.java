package com.example.bookmaker;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class hockey extends setCouponClick{

    private static View couponBox;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hokej);
        couponBox = findViewById(R.id.couponbox);
        coupon.setCouponBox(couponBox);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        /// xddddddd
        LinearLayout layout = findViewById(R.id.couponlayout);
//        String[] sports = new String[]{"icehockey_nhl","icehockey_sweden_hockey_league","icehockey_sweden_allsvenskan"};
//        boolean createHeader=false;
//        boolean lastarray = false;
//        if(sports.length>1)
//            createHeader=true;
//        for(int i=0;i<sports.length;i++) {
//            if(i==sports.length-1)
//                lastarray=true;
//            GetOdds getOdds = new GetOdds(this,layout,sports[i],createHeader,lastarray,couponBox);
//            getOdds.execute();
//        }
        String events ="[{\"id\":\"53e5ba2565f8633771fe722775a58577\",\"sport_key\":\"basketball_nba\",\"sport_title\":\"NBA\",\"commence_time\":\"2023-04-29T00:00:00Z\",\"home_team\":\"Golden State Warriors\",\"away_team\":\"Sacramento Kings\",\"bookmakers\":[{\"key\":\"sport888\",\"title\":\"888sport\",\"last_update\":\"2023-04-28T13:34:43Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:43Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.3},{\"name\":\"Sacramento Kings\",\"price\":3.5}]}]},{\"key\":\"betonlineag\",\"title\":\"BetOnline.ag\",\"last_update\":\"2023-04-28T13:35:01Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:01Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.33},{\"name\":\"Sacramento Kings\",\"price\":3.5}]}]},{\"key\":\"unibet_eu\",\"title\":\"Unibet\",\"last_update\":\"2023-04-28T13:30:44Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:30:44Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.33},{\"name\":\"Sacramento Kings\",\"price\":3.45}]}]},{\"key\":\"betfair\",\"title\":\"Betfair\",\"last_update\":\"2023-04-28T13:34:38Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.36},{\"name\":\"Sacramento Kings\",\"price\":3.7}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.38},{\"name\":\"Sacramento Kings\",\"price\":3.8}]}]},{\"key\":\"mybookieag\",\"title\":\"MyBookie.ag\",\"last_update\":\"2023-04-28T13:34:50Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:50Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.33},{\"name\":\"Sacramento Kings\",\"price\":3.4}]}]},{\"key\":\"nordicbet\",\"title\":\"Nordic Bet\",\"last_update\":\"2023-04-28T13:35:22Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:22Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.32},{\"name\":\"Sacramento Kings\",\"price\":3.5}]}]},{\"key\":\"matchbook\",\"title\":\"Matchbook\",\"last_update\":\"2023-04-28T13:32:32Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.35},{\"name\":\"Sacramento Kings\",\"price\":3.7}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.37},{\"name\":\"Sacramento Kings\",\"price\":3.8}]}]},{\"key\":\"pinnacle\",\"title\":\"Pinnacle\",\"last_update\":\"2023-04-28T13:34:25Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:25Z\",\"outcomes\":[{\"name\":\"Golden State Warriors\",\"price\":1.33},{\"name\":\"Sacramento Kings\",\"price\":3.62}]}]}]},{\"id\":\"0a4f6c6e735990f73125f5be39707768\",\"sport_key\":\"basketball_nba\",\"sport_title\":\"NBA\",\"commence_time\":\"2023-04-29T02:30:00Z\",\"home_team\":\"Los Angeles Lakers\",\"away_team\":\"Memphis Grizzlies\",\"bookmakers\":[{\"key\":\"betonlineag\",\"title\":\"BetOnline.ag\",\"last_update\":\"2023-04-28T13:35:01Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:01Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.51},{\"name\":\"Memphis Grizzlies\",\"price\":2.7}]}]},{\"key\":\"sport888\",\"title\":\"888sport\",\"last_update\":\"2023-04-28T13:34:43Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:43Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.47},{\"name\":\"Memphis Grizzlies\",\"price\":2.7}]}]},{\"key\":\"pinnacle\",\"title\":\"Pinnacle\",\"last_update\":\"2023-04-28T13:34:25Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:25Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.51},{\"name\":\"Memphis Grizzlies\",\"price\":2.75}]}]},{\"key\":\"betfair\",\"title\":\"Betfair\",\"last_update\":\"2023-04-28T13:34:38Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.55},{\"name\":\"Memphis Grizzlies\",\"price\":2.76}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.57},{\"name\":\"Memphis Grizzlies\",\"price\":2.8}]}]},{\"key\":\"unibet_eu\",\"title\":\"Unibet\",\"last_update\":\"2023-04-28T13:30:44Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:30:44Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.51},{\"name\":\"Memphis Grizzlies\",\"price\":2.65}]}]},{\"key\":\"mybookieag\",\"title\":\"MyBookie.ag\",\"last_update\":\"2023-04-28T13:34:50Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:50Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.51},{\"name\":\"Memphis Grizzlies\",\"price\":2.65}]}]},{\"key\":\"nordicbet\",\"title\":\"Nordic Bet\",\"last_update\":\"2023-04-28T13:35:22Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:22Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.49},{\"name\":\"Memphis Grizzlies\",\"price\":2.7}]}]},{\"key\":\"matchbook\",\"title\":\"Matchbook\",\"last_update\":\"2023-04-28T13:32:32Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.54},{\"name\":\"Memphis Grizzlies\",\"price\":2.78}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Los Angeles Lakers\",\"price\":1.57},{\"name\":\"Memphis Grizzlies\",\"price\":2.84}]}]}]},{\"id\":\"44d190bba82d78e42a9b0e6e4d98c63f\",\"sport_key\":\"basketball_nba\",\"sport_title\":\"NBA\",\"commence_time\":\"2023-04-30T00:30:00Z\",\"home_team\":\"Denver Nuggets\",\"away_team\":\"Phoenix Suns\",\"bookmakers\":[{\"key\":\"unibet_eu\",\"title\":\"Unibet\",\"last_update\":\"2023-04-28T13:30:44Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:30:44Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.7},{\"name\":\"Phoenix Suns\",\"price\":2.23}]}]},{\"key\":\"mybookieag\",\"title\":\"MyBookie.ag\",\"last_update\":\"2023-04-28T13:34:50Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:50Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.72},{\"name\":\"Phoenix Suns\",\"price\":2.13}]}]},{\"key\":\"sport888\",\"title\":\"888sport\",\"last_update\":\"2023-04-28T13:34:43Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:43Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.67},{\"name\":\"Phoenix Suns\",\"price\":2.2}]}]},{\"key\":\"betfair\",\"title\":\"Betfair\",\"last_update\":\"2023-04-28T13:34:38Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.73},{\"name\":\"Phoenix Suns\",\"price\":2.28}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.79},{\"name\":\"Phoenix Suns\",\"price\":2.38}]}]},{\"key\":\"betonlineag\",\"title\":\"BetOnline.ag\",\"last_update\":\"2023-04-28T13:35:01Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:01Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.71},{\"name\":\"Phoenix Suns\",\"price\":2.2}]}]},{\"key\":\"matchbook\",\"title\":\"Matchbook\",\"last_update\":\"2023-04-28T13:32:32Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.71},{\"name\":\"Phoenix Suns\",\"price\":2.3}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.77},{\"name\":\"Phoenix Suns\",\"price\":2.42}]}]},{\"key\":\"nordicbet\",\"title\":\"Nordic Bet\",\"last_update\":\"2023-04-28T13:35:22Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:22Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.71},{\"name\":\"Phoenix Suns\",\"price\":2.2}]}]},{\"key\":\"pinnacle\",\"title\":\"Pinnacle\",\"last_update\":\"2023-04-28T13:34:25Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:25Z\",\"outcomes\":[{\"name\":\"Denver Nuggets\",\"price\":1.71},{\"name\":\"Phoenix Suns\",\"price\":2.27}]}]}]},{\"id\":\"f4a64f0803fb3388eae1e1c87823a05b\",\"sport_key\":\"basketball_nba\",\"sport_title\":\"NBA\",\"commence_time\":\"2023-04-30T17:00:00Z\",\"home_team\":\"New York Knicks\",\"away_team\":\"Miami Heat\",\"bookmakers\":[{\"key\":\"sport888\",\"title\":\"888sport\",\"last_update\":\"2023-04-28T13:34:43Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:43Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.5},{\"name\":\"New York Knicks\",\"price\":1.53}]}]},{\"key\":\"betfair\",\"title\":\"Betfair\",\"last_update\":\"2023-04-28T13:34:38Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.6},{\"name\":\"New York Knicks\",\"price\":1.57}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.74},{\"name\":\"New York Knicks\",\"price\":1.62}]}]},{\"key\":\"matchbook\",\"title\":\"Matchbook\",\"last_update\":\"2023-04-28T13:32:32Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.6},{\"name\":\"New York Knicks\",\"price\":1.58}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.74},{\"name\":\"New York Knicks\",\"price\":1.63}]}]},{\"key\":\"mybookieag\",\"title\":\"MyBookie.ag\",\"last_update\":\"2023-04-28T13:34:50Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:50Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.42},{\"name\":\"New York Knicks\",\"price\":1.57}]}]},{\"key\":\"betonlineag\",\"title\":\"BetOnline.ag\",\"last_update\":\"2023-04-28T13:35:01Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:01Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.57},{\"name\":\"New York Knicks\",\"price\":1.56}]}]},{\"key\":\"nordicbet\",\"title\":\"Nordic Bet\",\"last_update\":\"2023-04-28T13:35:22Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:22Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.55},{\"name\":\"New York Knicks\",\"price\":1.54}]}]},{\"key\":\"pinnacle\",\"title\":\"Pinnacle\",\"last_update\":\"2023-04-28T13:34:25Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:25Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.6},{\"name\":\"New York Knicks\",\"price\":1.56}]}]},{\"key\":\"unibet_eu\",\"title\":\"Unibet\",\"last_update\":\"2023-04-28T13:30:44Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:30:44Z\",\"outcomes\":[{\"name\":\"Miami Heat\",\"price\":2.55},{\"name\":\"New York Knicks\",\"price\":1.56}]}]}]},{\"id\":\"bcd6fb33fb5797ee8e2713a11ce3a947\",\"sport_key\":\"basketball_nba\",\"sport_title\":\"NBA\",\"commence_time\":\"2023-05-01T23:30:00Z\",\"home_team\":\"Boston Celtics\",\"away_team\":\"Philadelphia 76ers\",\"bookmakers\":[{\"key\":\"sport888\",\"title\":\"888sport\",\"last_update\":\"2023-04-28T13:34:43Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:43Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.33},{\"name\":\"Philadelphia 76ers\",\"price\":3.3}]}]},{\"key\":\"unibet_eu\",\"title\":\"Unibet\",\"last_update\":\"2023-04-28T13:30:44Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:30:44Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.36},{\"name\":\"Philadelphia 76ers\",\"price\":3.2}]}]},{\"key\":\"betfair\",\"title\":\"Betfair\",\"last_update\":\"2023-04-28T13:34:38Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.4},{\"name\":\"Philadelphia 76ers\",\"price\":3.2}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:34:38Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.46},{\"name\":\"Philadelphia 76ers\",\"price\":3.5}]}]},{\"key\":\"betonlineag\",\"title\":\"BetOnline.ag\",\"last_update\":\"2023-04-28T13:35:01Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:01Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.39},{\"name\":\"Philadelphia 76ers\",\"price\":3.15}]}]},{\"key\":\"matchbook\",\"title\":\"Matchbook\",\"last_update\":\"2023-04-28T13:32:32Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.37},{\"name\":\"Philadelphia 76ers\",\"price\":3.1}]},{\"key\":\"h2h_lay\",\"last_update\":\"2023-04-28T13:32:32Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.47},{\"name\":\"Philadelphia 76ers\",\"price\":3.65}]}]},{\"key\":\"mybookieag\",\"title\":\"MyBookie.ag\",\"last_update\":\"2023-04-28T13:34:50Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:50Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.37},{\"name\":\"Philadelphia 76ers\",\"price\":3.2}]}]},{\"key\":\"nordicbet\",\"title\":\"Nordic Bet\",\"last_update\":\"2023-04-28T13:35:22Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:35:22Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.36},{\"name\":\"Philadelphia 76ers\",\"price\":3.2}]}]},{\"key\":\"pinnacle\",\"title\":\"Pinnacle\",\"last_update\":\"2023-04-28T13:34:25Z\",\"markets\":[{\"key\":\"h2h\",\"last_update\":\"2023-04-28T13:34:25Z\",\"outcomes\":[{\"name\":\"Boston Celtics\",\"price\":1.36},{\"name\":\"Philadelphia 76ers\",\"price\":3.38}]}]}]}]\n";
        dynamicButtonCreate test = new dynamicButtonCreate(this, layout,events,false, couponBox,"basketball_nba");
        test.getEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        coupon.setCouponBox(couponBox);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}