package com.ecom.service;

import com.ecom.model.Home;
import com.ecom.model.HomeCategory;

import java.util.List;

public interface HomeService {

    Home createHomePageData( List<HomeCategory> categories);

}
