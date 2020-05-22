package com.example.events;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class OnInfosProfileEvent implements Serializable {
	private static final long serialVersionUID = 227418832862914437L;

	private String username;

	private Boolean infosACompleted;

	private Boolean infosBCompleted;

	private Boolean infosDCompleted;

	private Integer completionPercentage;
}
