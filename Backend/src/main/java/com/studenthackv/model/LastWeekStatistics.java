package com.studenthackv.model;

import java.util.List;

public class LastWeekStatistics {

  private final List<Double> paidPricePerDay;
  private final List<Double> minimumPricePerDay;

  public LastWeekStatistics(
      List<Double> paidPricePerDay,
      List<Double> minimumPricePerDay) {
    this.paidPricePerDay = paidPricePerDay;
    this.minimumPricePerDay = minimumPricePerDay;
  }

  public List<Double> getPaidPricePerDay() {
    return paidPricePerDay;
  }

  public List<Double> getMinimumPricePerDay() {
    return minimumPricePerDay;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LastWeekStatistics that = (LastWeekStatistics) o;

    if (paidPricePerDay != null ? !paidPricePerDay.equals(that.paidPricePerDay) :
        that.paidPricePerDay != null) {
      return false;
    }
    return minimumPricePerDay != null ? minimumPricePerDay.equals(that.minimumPricePerDay) :
        that.minimumPricePerDay == null;

  }

  @Override
  public int hashCode() {
    int result = paidPricePerDay != null ? paidPricePerDay.hashCode() : 0;
    result = 31 * result + (minimumPricePerDay != null ? minimumPricePerDay.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("LastWeekStatistics{");
    sb.append("paidPricePerDay=").append(paidPricePerDay);
    sb.append(", minimumPricePerDay=").append(minimumPricePerDay);
    sb.append('}');
    return sb.toString();
  }
}
