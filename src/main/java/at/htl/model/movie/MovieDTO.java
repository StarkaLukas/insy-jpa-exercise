package at.htl.model.movie;

import at.htl.model.sale.SaleDTO;
import at.htl.workloads.language.Language;

import java.util.List;

public class MovieDTO {

    private Long id;
    private String title;
    private Integer year;
    private Double duration;
    private Double rating;
    private Language language;
    private List<SaleDTO> saleList;


}
