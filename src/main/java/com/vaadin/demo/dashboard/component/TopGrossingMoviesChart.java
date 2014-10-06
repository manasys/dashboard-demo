package com.vaadin.demo.dashboard.component;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Credits;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsBar;
import com.vaadin.addon.charts.model.Series;
import com.vaadin.addon.charts.model.Tooltip;
import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.demo.dashboard.domain.Movie;

public class TopGrossingMoviesChart extends Chart {

    private static Color[] colors = new Color[] { new SolidColor("#FA9E00"),
            new SolidColor("#8CB206"), new SolidColor("#519BC2"),
            new SolidColor("#FACF00"), new SolidColor("#B0DC07"),
            new SolidColor("#76BCE0") };

    public TopGrossingMoviesChart() {
        // TODO this don't actually visualize top grossing movies, but just
        // makes a
        // bar chart of movie scores

        setCaption("Top Grossing Movies");
        getConfiguration().setTitle("");
        getConfiguration().getChart().setType(ChartType.BAR);
        getConfiguration().getxAxis().getLabels().setEnabled(false);
        getConfiguration().getxAxis().setTickWidth(0);
        setSizeFull();

        List<Movie> movies = new ArrayList<Movie>(DashboardUI.getDataProvider()
                .getMovies());

        List<Series> series = new ArrayList<Series>();
        for (int i = 0; i < 6; i++) {
            Movie movie = movies.get(i);
            PlotOptionsBar opts = new PlotOptionsBar();
            opts.setColor(colors[5 - i]);
            opts.setBorderWidth(0);
            opts.setShadow(false);
            opts.setPointPadding(0.4);
            ListSeries item = new ListSeries(movie.getTitle(), movie.getScore());
            item.setPlotOptions(opts);
            series.add(item);

        }
        getConfiguration().setSeries(series);

        Credits c = new Credits("");
        getConfiguration().setCredits(c);

        Tooltip tooltip = new Tooltip();
        tooltip.setPointFormat("{series.name}: {point.percentage}%");
        tooltip.setValueDecimals(1);
        tooltip.setEnabled(false);
        getConfiguration().setTooltip(tooltip);

        PlotOptionsBar opts = new PlotOptionsBar();
        opts.setGroupPadding(0);
        getConfiguration().setPlotOptions(opts);

    }
}
