package com.hr.hrmanagement.service;

import com.hr.hrmanagement.entity.Log;
import java.util.List;

public interface LogService {
    void saveLog(Log log);
    List<Log> getAllLogs();
}