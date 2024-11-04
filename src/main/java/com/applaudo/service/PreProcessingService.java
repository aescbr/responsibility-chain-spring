package com.applaudo.service;

import com.applaudo.model.POEmailRequest;
import com.applaudo.model.Result;
import com.applaudo.model.WrapperTransaction;

public interface PreProcessingService {
    WrapperTransaction processRequest(WrapperTransaction txt);
}
