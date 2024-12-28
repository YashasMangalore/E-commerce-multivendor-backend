package com.ecom.service;

import com.ecom.model.Seller;
import com.ecom.model.SellerReport;

public interface SellerReportService {
    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport( SellerReport sellerReport);

}
