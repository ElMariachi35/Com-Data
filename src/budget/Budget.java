package budget;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import model.BaseEntity;
import model.User;

@Entity
@NamedQuery(name=Budget.FIND_LATEST_BY_USER, query="SELECT b from Budget b WHERE b.user=:"+Budget.PARAM_USER+" ORDER BY b.timeStamp DESC")
public class Budget extends BaseEntity {
	
	public static final String FIND_LATEST_BY_USER = "Budget.findLatestByUser";
	public static final String PARAM_USER = "user";
	
	private BigDecimal budget;
	private Date timeStamp;
	@ManyToOne
	private User user;

	public Budget() {
	}
	
	public Budget(BigDecimal budget, Date timeStamp, User user) {
		this.budget = budget;
		this.timeStamp = timeStamp;
		this.user = user;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
