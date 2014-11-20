package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class User extends BaseEntity {

	private String name;
	private BigDecimal startCapital;
	private BigDecimal balanceOffset;
	private long points;
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<UserAlias> userAlias;
	
	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getStartCapital() {
		return startCapital;
	}

	public void setStartCapital(BigDecimal startCapital) {
		this.startCapital = startCapital;
	}

	public BigDecimal getBalanceOffset() {
		return balanceOffset;
	}

	public void setBalanceOffset(BigDecimal balanceOffset) {
		this.balanceOffset = balanceOffset;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public List<UserAlias> getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(List<UserAlias> userAlias) {
		this.userAlias = userAlias;
	}

}
