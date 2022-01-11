CREATE TABLE resort_activity_junction (
    resort_id BIGINT NOT NULL,
    activity_id BIGINT NOT NULL,

    CONSTRAINT res_act_pk PRIMARY KEY (resort_id, activity_id),
    CONSTRAINT FK_resort FOREIGN KEY (resort_id) REFERENCES resorts (id),
    CONSTRAINT FK_activity FOREIGN KEY (activity_id) REFERENCES activities (id)
);