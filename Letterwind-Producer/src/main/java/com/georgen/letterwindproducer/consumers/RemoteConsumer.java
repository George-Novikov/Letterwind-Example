package com.georgen.letterwindproducer.consumers;

import com.georgen.letterwind.api.annotations.LetterwindConsumer;
import com.georgen.letterwindproducer.model.SampleMessage;

public class RemoteConsumer {
    /** This method is left empty because it's just a descriptor for the remote consumer */
    @LetterwindConsumer
    public void receive(SampleMessage message){}
}
