// This file is part of OpenTSDB.
// Copyright (C) 2015  The OpenTSDB Authors.
//
// This program is free software: you can redistribute it and/or modify it
// under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 2.1 of the License, or (at your
// option) any later version.  This program is distributed in the hope that it
// will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
// of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser
// General Public License for more details.  You should have received a copy
// of the GNU Lesser General Public License along with this program.  If not,
// see <http://www.gnu.org/licenses/>.
package com.jcloud.monitor.tsd;

import com.jcloud.monitor.core.IllegalDataException;
import com.jcloud.monitor.core.IncomingDataPoint;
import com.jcloud.monitor.core.TSDB;
import com.jcloud.monitor.stats.StatsCollector;

import com.stumbleupon.async.Deferred;

public class DummySEHPlugin extends StorageExceptionHandler {

  @Override
  public void initialize(TSDB tsdb) {
    if (tsdb == null) {
      throw new IllegalArgumentException("The TSDB object was null");
    }
    // a dummy config to check for throwing exceptions
    if (!tsdb.getConfig().hasProperty(
        "tsd.core.storage_exception_handler.DummySEHPlugin.hosts")) {
      throw new IllegalArgumentException("Missing hosts config");
    }
  }

  @Override
  public Deferred<Object> shutdown() {
    return Deferred.fromResult(new Object());
  }

  @Override
  public String version() {
    return "2.2.0";
  }

  @Override
  public void collectStats(StatsCollector collector) {
    collector.record("seh.dummy.retries", 1);
  }

  @Override
  public void handleError(IncomingDataPoint dp, Exception exception) {
    if (dp == null) {
      throw new IllegalArgumentException("Missing Data Point");
    }
    if (dp.getValue().equals("42")) {
      throw new IllegalDataException("Testing");
    }
  }

}
