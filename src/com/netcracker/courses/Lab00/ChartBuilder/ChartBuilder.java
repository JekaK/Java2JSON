package com.netcracker.courses.Lab00.ChartBuilder;

import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jeka on 10.12.16.
 */

public class ChartBuilder {

    private long[] results;
    private String[] names;

    private ChartBuilder() {

    }

    public String[] getNames() {
        return names;
    }

    public long[] getResults() {
        return results;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setResults(long[] results) {
        this.results = results;
    }

    public static Builder newBuilder() {
        return new ChartBuilder().new Builder();
    }

    public void generateChart() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet workSheet = workbook.createSheet("ResultsChart");
        for (int rowIndex = 0; rowIndex < 2; rowIndex++) {
            XSSFRow row = workSheet.createRow((short) rowIndex);
            for (int colIndex = 0; colIndex < results.length; colIndex++) {
                XSSFCell cell = row.createCell((short) colIndex);
                if (rowIndex == 0) {
                    cell.setCellValue(0);
                } else {
                    cell.setCellValue(results[colIndex]);
                }
            }
        }
        XSSFDrawing drawing = workSheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 20, 100);
        XSSFChart chart = drawing.createChart(anchor);
        XSSFChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.BOTTOM);
        LineChartData data = chart.getChartDataFactory().createLineChartData();
        ChartAxis bottomAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.BOTTOM);
        bottomAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        bottomAxis.setMinimum(1);
        bottomAxis.setMaximum(2);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(workSheet, new CellRangeAddress(0, 0, 0, 0));
        for (int i = 0; i < results.length; i++) {
            LineChartSeries chartSeries = data.addSeries(xs, DataSources.fromNumericCellRange(workSheet, new CellRangeAddress(0, 1, i, i)));
            chartSeries.setTitle(names[i]);
        }
        chart.plot(data, new ChartAxis[]{bottomAxis, leftAxis});
        FileOutputStream fileOut = new FileOutputStream("lineChart.xlsx");
        workbook.write(fileOut);
        fileOut.close();
    }

    public class Builder {
        private Builder() {

        }

        public Builder withNames(String[] names) {
            ChartBuilder.this.names = names;
            return this;
        }

        public Builder withResults(long[] results) {
            ChartBuilder.this.results = results;
            return this;
        }

        public ChartBuilder build() {
            return ChartBuilder.this;
        }
    }
}
