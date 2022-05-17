package com.sn.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ehsan Sh
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Position{
    private double latitude;
    private double longitude;
}