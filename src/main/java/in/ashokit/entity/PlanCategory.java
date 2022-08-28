package in.ashokit.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_CATEGORY") 
public class PlanCategory {

	@Id
 	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categorytId;

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@Column(name = "ACTIVE_SWITCH")
	private String activeSw;// to enable or disable data( y or N)

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "CREATED_DATE", updatable = false) // once the record got created that column should not be updated
	@CreationTimestamp // date updated automatically
	private LocalDate createdate;

	@Column(name = "UPDATED_DATE", insertable = false) // once the record got updated that column should not be inserted
	@UpdateTimestamp // date updated automatically
	private LocalDate updateDate;

}
