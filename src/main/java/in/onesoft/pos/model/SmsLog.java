package in.onesoft.pos.model;

import java.time.OffsetDateTime;

public class SmsLog {
    public Long id;
    public Long companyId;
    public Long partyId;
    public String mobileNo;
    public String messageText;
    public String status;
    public String providerResponse;
    public OffsetDateTime createdAt;
}