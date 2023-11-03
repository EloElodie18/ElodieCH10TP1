package co.simplon.poo.ch10.layer.model.article;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleSport extends Article {

	private String sport;

	public ArticleSport(String reference, String libelle, String sport) {
		super(reference, libelle);
		this.sport = sport;
	}
}
