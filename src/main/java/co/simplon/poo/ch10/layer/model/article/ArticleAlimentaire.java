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
public class ArticleAlimentaire extends Article {

	private int calories;

	public ArticleAlimentaire(String reference, String libelle, int calories) {
		super(reference, libelle);
		this.calories = calories;
	}
}
